package com.accenture.mvvm.view.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.accenture.mvvm.R;
import com.accenture.mvvm.databinding.FragmentDownloadBinding;

public class DownloadFragment extends Fragment {

    int i = 0;
    int flag = 1;

    protected Activity mContext;
    FragmentDownloadBinding fragmentDownloadBinding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = getActivity();
    }

    Runnable updateProgress = new Runnable() {
        @Override
        public void run() {
            Message msg = handler.obtainMessage();
            msg.arg1=i;
            handler.sendMessage(msg);
            fragmentDownloadBinding.progressBar.setProgress(msg.arg1);
            if(i<=100){
                fragmentDownloadBinding.textView.setText(msg.arg1+"%");
                i+=10;
            } else {
                handler.removeCallbacks(updateProgress);
            }
        }
    };

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.arg1 < 100 ) {
                handler.postDelayed(updateProgress, 1000);
                ++flag;
            }
            else {
                fragmentDownloadBinding.imageView.setVisibility(fragmentDownloadBinding.imageView.VISIBLE);
                i = 0;
            }
            if(msg.arg1 == 100) {
                flag = 2;
                Toast.makeText(getContext(),"Download successful!",Toast.LENGTH_LONG).show();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentDownloadBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_download, container, false);

        fragmentDownloadBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1) {
                    handler.post(updateProgress);
                }else if(flag == 2) {
                    Toast.makeText(getContext(),"Downloaded,Don't click it again!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Downloading,Please waiting!",Toast.LENGTH_LONG).show();
                }
            }
        });
        fragmentDownloadBinding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentDownloadBinding.imageView.setVisibility(fragmentDownloadBinding.imageView.INVISIBLE);
                fragmentDownloadBinding.textView.setText(i + "%");
                fragmentDownloadBinding.progressBar.setProgress(i);
                Toast.makeText(getContext(), "Reset successful,you can download again!", Toast.LENGTH_LONG).show();
                flag = 1;
            }
        });
        return fragmentDownloadBinding.getRoot();
    }
}

