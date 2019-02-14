package com.accenture.mvvm.view.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
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

import com.accenture.mvvm.R;
import com.accenture.mvvm.databinding.FragmentListBinding;
import com.accenture.mvvm.model.ItemEntity;
import com.accenture.mvvm.utils.CustomProgressDialog;
import com.accenture.mvvm.view.Adapters.ItemAdapter;
import com.accenture.mvvm.viewModel.RecyclerListViewModel;
import java.util.ArrayList;
import java.util.List;


public class RecyclerListFragment extends Fragment{

    protected Activity mContext;
    private FragmentListBinding fragmentListBinding;
    List<ItemEntity> itemEntityList = new ArrayList<ItemEntity>();
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
        new RecyclerListViewModel().initData(itemEntityList);
        initItem();
        return fragmentListBinding.getRoot();
    }
    public void initItem() {
        fragmentListBinding.recyclerView.setLayoutManager(new LinearLayoutManager(fragmentListBinding.recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));

        final ItemAdapter itemAdapter = new ItemAdapter(itemEntityList);

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
                        new RecyclerListViewModel().sort(itemEntityList);
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

