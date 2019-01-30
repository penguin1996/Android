package com.liang.tablayoutdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GirlsAdapter extends ArrayAdapter {

   private final int resourceId;

    private ImageView girlsImage;
    private TextView textView2;

    public GirlsAdapter(@NonNull Context context,int resource,@NonNull List<Girls> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, @NonNull  ViewGroup parent) {
        Girls girls =(Girls)getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        girlsImage = view.findViewById(R.id.imageView2);
        textView2 = view.findViewById(R.id.textView2);
        girlsImage.setImageResource(girls.getImageId());
        textView2.setText(girls.getContent());
        return view;
    }
}
