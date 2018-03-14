package com.example.android.animationsdemo.Objects;

/**
 * Created by ayush on 4/3/18.
 */

public class GridDataModel {

    public String text;
    public int drawable;
    public String color;

    public GridDataModel(String t, int d, String c )
    {
        text=t;
        drawable=d;
        color=c;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getColor() {
        return color;
    }
}
