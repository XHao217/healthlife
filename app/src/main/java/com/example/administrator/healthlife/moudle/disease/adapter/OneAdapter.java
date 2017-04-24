package com.example.administrator.healthlife.moudle.disease.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseAdapter;
import com.example.administrator.healthlife.base.BaseViewHolder;
import com.example.administrator.healthlife.moudle.disease.bean.OneBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/18.
 */

public class OneAdapter extends BaseAdapter<OneAdapter.OneViewHolder>{
    ViewOnClickListener mViewOnClickListener;
    ArrayList<OneBean.ListBean> mListBean=new ArrayList<>();
    public OneAdapter(ViewOnClickListener mViewOnClickListener,ArrayList<OneBean.ListBean> mListBean){
        super(mViewOnClickListener);
        this.mViewOnClickListener=mViewOnClickListener;
        this.mListBean=mListBean;
    }
    @Override
    public OneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(), R.layout.item_one,null);
        OneViewHolder oneViewHolder=new OneViewHolder(view,mViewOnClickListener);
        return oneViewHolder;
    }

    @Override
    public void onBindViewHolder(OneViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OneViewHolder extends BaseViewHolder{

        public OneViewHolder(View itemView, BaseAdapter.ViewOnClickListener viewOnClickListener) {
            super(itemView, viewOnClickListener);
        }
    }
}

