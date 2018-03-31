package com.example.android.animationsdemo.Objects;

/**
 * Created by ayush on 1/4/18.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.animationsdemo.R;

/**
 * Represents the set of information contained in one result row
 */
public class SearchResultItem implements Parcelable {

    private String header;
    private String subHeader;
    private Integer leftIcon;
    private Integer rightIcon;

    // Constructors ________________________________________________________________________________
    public SearchResultItem() {
        this.header = "Error";
        this.subHeader = "Error";
        this.leftIcon = R.mipmap.ic_clock_icon;
        this.rightIcon = R.mipmap.ic_arrow_right_up_icon;
    }

    public SearchResultItem(String header, String subHeader, Integer leftIcon, Integer rightIcon) {
        this.setHeader(header);
        this.setSubHeader(subHeader);
        this.setLeftIcon(leftIcon);
        this.setRightIcon(rightIcon);
    }

    // Getters and Setters__________________________________________________________________________
    public Integer getLeftIcon() {
        return leftIcon;
    }

    public void setLeftIcon(Integer leftIcon) {
        if (leftIcon != null && leftIcon != 0 && leftIcon != -1) {
            this.leftIcon = leftIcon;
        } else {
            this.leftIcon = R.mipmap.ic_clock_icon;
        }
    }

    public Integer getRightIcon() {
        return rightIcon;
    }

    public void setRightIcon(Integer rightIcon) {
        if (rightIcon != null && rightIcon != 0 && rightIcon != -1) {
            this.rightIcon = rightIcon;
        } else {
            this.rightIcon = R.mipmap.ic_arrow_right_up_icon;
        }
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        if (subHeader != null && !"".equals(subHeader)) {
            this.subHeader = subHeader;
        } else {
            this.subHeader = "Error (Empty data)";
        }
    }

    // Parcelable contract implementation __________________________________________________________
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(header);
        dest.writeString(subHeader);
        dest.writeInt(leftIcon);
        dest.writeInt(rightIcon);
    }

    // Parcelable Creator Implementation ___________________________________________________________
    public static final Parcelable.Creator<SearchResultItem> CREATOR = new Creator<SearchResultItem>() {

        public SearchResultItem createFromParcel(Parcel in) {
            SearchResultItem searchResultItem = new SearchResultItem();

            searchResultItem.setHeader(in.readString());
            searchResultItem.setSubHeader(in.readString());
            searchResultItem.setLeftIcon(in.readInt());
            searchResultItem.setRightIcon(in.readInt());

            return searchResultItem;
        }

        public SearchResultItem[] newArray(int size) {
            return new SearchResultItem[size];
        }
    };
}