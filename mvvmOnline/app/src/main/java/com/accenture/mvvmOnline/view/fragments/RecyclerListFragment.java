package com.accenture.mvvmOnline.view.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.accenture.mvvmOnline.model.ItemEntities;
import com.accenture.mvvmOnline.view.adapters.ItemAdapter;
import com.accenture.mvvmOnline.view.adapters.utils.CustomProgressDialog;
import com.accenture.mvvmOnline.viewModel.RecyclerListViewModel;
import com.accenture.myapplication.R;
import com.accenture.myapplication.databinding.FragmentListBinding;
import java.util.ArrayList;
import java.util.List;

public class RecyclerListFragment extends Fragment {
    protected Activity mContext;
    private FragmentListBinding fragmentListBinding;
    List<ItemEntities.ResultsBean> itemEntityList = new ArrayList<ItemEntities.ResultsBean>();
    List<Uri> uri = new ArrayList<>();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        new RecyclerListViewModel(getContext(),fragmentListBinding).loadData(getContext().getString(R.string.android),10,1);
        initItem();
        return fragmentListBinding.getRoot();
    }
    public void initItem() {
        fragmentListBinding.recyclerView.setLayoutManager(new LinearLayoutManager(fragmentListBinding.recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));

        final ItemAdapter itemAdapter = new ItemAdapter(getContext(),itemEntityList,uri);

        fragmentListBinding.recyclerView.setAdapter(itemAdapter);

        fragmentListBinding.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                final Dialog mDialog = CustomProgressDialog.createLoadingDialog(getContext(), "Loading");
                mDialog.setCancelable(true);
                mDialog.show();
                fragmentListBinding.swipe.setRefreshing(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new RecyclerListViewModel(getContext(),fragmentListBinding).loadData(getContext().getString(R.string.iOS),10,1);
                        itemAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), "Refresh finished!", Toast.LENGTH_LONG).show();
                        /*mDialog.hide();*/
                        mDialog.dismiss();
                    }
                }, 4000);
            }
        });
    }
}

