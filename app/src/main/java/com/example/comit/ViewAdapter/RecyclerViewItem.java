package com.example.comit.ViewAdapter;

import android.graphics.drawable.Drawable;

public class RecyclerViewItem {
    private Drawable iconDrawable;
    private String mainTitle;
    private String subTitle;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }
    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public Drawable getIconDrawable() {
        return iconDrawable;
    }
    public String getMainTitle() {
        return mainTitle;
    }
    public String getSubTitle() {
        return subTitle;
    }
}


