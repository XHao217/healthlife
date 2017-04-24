package com.example.administrator.healthlife.moudle.science.bean;

import com.example.administrator.healthlife.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/4.
 */

public class ScienceTabBean {
    private String title;
    private BaseFragment fragment;

    public ScienceTabBean(String title, BaseFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseFragment getFragment() {
        return fragment;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }
}
