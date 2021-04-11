package com.example.comit.ViewAdapter;

import android.graphics.drawable.Drawable;

public class RecyclerViewItem {
    private Drawable iconDrawable;
    private String mainTitle;
    private String subTitle;
    private String Date;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }
    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public void setDate(String Date){this.Date = Date;
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
    public String getDate(){
        return Date;
    }
}


