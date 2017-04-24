package com.example.administrator.healthlife.bean;

/**
 * Created by Administrator on 2017/4/2.
 */

public class TabBean {
    private String title;
    private int icon;
    private int iconChooseResId;
    private int iconNormalResId;

    public int getIconChooseResId() {
        return iconChooseResId;
    }

    public void setIconChooseResId(int iconChooseResId) {
        this.iconChooseResId = iconChooseResId;
    }

    public int getIconNormalResId() {
        return iconNormalResId;
    }

    public void setIconNormalResId(int iconNormalResId) {
        this.iconNormalResId = iconNormalResId;
    }

    //正常的tab 下标
    private int index;


    public TabBean(String title,int iconChooseResId, int iconNormalResId) {
        this.title = title;
        this.iconChooseResId = iconChooseResId;
        this.iconNormalResId = iconNormalResId;
        this.index = index;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public TabBean(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
