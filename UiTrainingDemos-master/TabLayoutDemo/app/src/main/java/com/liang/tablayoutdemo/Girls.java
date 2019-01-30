package com.liang.tablayoutdemo;

public class Girls {

    private int imageId;

    private String content;

    Girls(int imageId,String content) {
        this.imageId = imageId;
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
