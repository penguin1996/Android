package com.liang.tablayoutdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TabFragment extends Fragment {
    private Button btn;
    private Button btn1;
    private TextView textView;
    private ProgressBar progressBar;
    private ImageView imageView;

    int i = 0;

    public static final String TITLE_TAG = "tabTitle";

    public static TabFragment newInstance(String tabTitle) {

        Bundle args = new Bundle();

        TabFragment fragment = new TabFragment();
        args.putString(TITLE_TAG, tabTitle);
        fragment.setArguments(args);
        return fragment;
    }

    Runnable updateProgress = new Runnable() {
        @Override
        public void run() {
            Message msg = handler.obtainMessage();
            msg.arg1=i;
            handler.sendMessage(msg);
            progressBar.setProgress(msg.arg1);
            if(i<=100){
                textView.setText(msg.arg1+"%");
                i+=10;
            } else {
                handler.removeCallbacks(updateProgress);
            }
        }
    };
/*
    Runnable deleteProgress = new Runnable() {
        int i=0;
        @Override
        public void run() {
            Message msg = handler1.obtainMessage();
            msg.arg1=i;
            handler1.sendMessage(msg);
            progressBar.setProgress(msg.arg1);
            textView.setText(msg.arg1+"%");
            handler1.removeCallbacks(deleteProgress);
        }
    };

    Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };*/

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.arg1 < 100 ) {
                handler.postDelayed(updateProgress, 1000);
            }else {
                imageView.setVisibility(imageView.VISIBLE);
                i = 0;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        textView = view.findViewById(R.id.textView);

        textView.setText(0+"%");

        imageView = view.findViewById(R.id.imageView);

        progressBar = view.findViewById(R.id.progressBar);

        btn = view.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                handler.post(updateProgress);
            }
        });

        btn1 = view.findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(imageView.INVISIBLE);
                textView.setText(i+"%");
                progressBar.setProgress(i);
            }
        });
        return view;
    }
}

