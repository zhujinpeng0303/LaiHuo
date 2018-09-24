package com.example.jason_jukes.laihuo.view.nineImage;


import android.util.Log;

/**
 * creator  Lukey on 2016/6/14
 */
public class Image {
    private String url;
    private int width;
    private int height;

    public Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {

        return "image---->>url="+
                url+"width="+
                width+"height"
                +height;
    }
}
