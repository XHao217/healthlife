package com.example.administrator.healthlife.base;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/4/3.
 */

public abstract class BaseAdapter<T extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<T> {
    public interface ViewOnClickListener{
        public void onClick(int position,View view);
    }
    public ViewOnClickListener viewOnClickListener;

    public BaseAdapter(){

    }

    public BaseAdapter(ViewOnClickListener viewOnClickListener) {
        this.viewOnClickListener = viewOnClickListener;
    }

    public void setViewOnClickListener(ViewOnClickListener viewOnClickListener) {
        this.viewOnClickListener = viewOnClickListener;
    }
}
