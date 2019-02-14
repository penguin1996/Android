package com.accenture.mvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class ItemEntity extends BaseObservable {
    private int imageUrl;
    private String content;

    public ItemEntity (int imageUrl,String content) {
        this.imageUrl = imageUrl;
        this.content = content;
    }

    @Bindable
    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
        notifyChange();
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyChange();
    }
}
