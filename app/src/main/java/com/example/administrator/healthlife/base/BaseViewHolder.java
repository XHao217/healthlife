package com.example.administrator.healthlife.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/4/3.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{
    public BaseViewHolder(final View itemView) {
        super(itemView);
    }
    public BaseViewHolder(final View itemView,final BaseAdapter.ViewOnClickListener
                          viewOnClickListener){
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewOnClickListener!=null){
                    viewOnClickListener.onClick(getAdapterPosition(),itemView);
                }
            }
        });
    }
}
