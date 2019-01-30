package com.liang.tablayoutdemo;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.shuffle;

public class ListFragment extends Fragment {

    private int i;

    private ImageView imageView;
    private ListView listView;
    private View view;
    private ArrayAdapter<Girls> adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    int[] images = {R.drawable.day0301,R.drawable.day0302,R.drawable.day0303,R.drawable.day0304,R.drawable.day0305,R.drawable.day0306,R.drawable.day0307,R.drawable.day0308};
    List<Girls> girlsList = new ArrayList<Girls>();

    public static final String TITLE_TAG = "tabTitle";

    public static ListFragment newInstance(String tabTitle) {
        Bundle args = new Bundle();
        ListFragment fragment = new ListFragment();
        args.putString(TITLE_TAG, tabTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.listView);
        imageView = view.findViewById(R.id.imageView1);
        swipeRefreshLayout = view.findViewById(R.id.swipe);

        initView();
        initGirls();
        return view;
    }

    private void initView() {

        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.CYAN);
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#DDA0DD"), Color.parseColor("#EE82EE"), Color.parseColor("#FF00FF"), Color.parseColor("#DC143C"));

        adapter = new GirlsAdapter(getActivity(), R.layout.girls_list, girlsList);
        listView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            Dialog mDialog = CustomProgressDialog.createLoadingDialog(getContext(), "Loading");

            @Override
            public void onRefresh() {

                swipeRefreshLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        mDialog.setCancelable(true);
                        mDialog.show();
                        swipeRefreshLayout.setRefreshing(false);
                        sort(girlsList);
                    }
                });
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mDialog.hide();
                        adapter.notifyDataSetChanged();
                    }
                }, 4000);
            }
        });
    }
    private void initGirls(){
        for(i = 0; i < images.length; i++) {
            Girls girls = new Girls(images[i],"item:"+i);
            girlsList.add(girls);
        }
    }
    private void sort(List<Girls> list) {
        for(i = 0; i < list.size(); i++) {
            list.get(i).setContent("Refresh item,the random num id:"+i);
        }
        shuffle(list);
    }
}