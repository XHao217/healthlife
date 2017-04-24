package com.example.administrator.healthlife.moudle.science.adapter;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseAdapter;
import com.example.administrator.healthlife.base.BaseViewHolder;
import com.example.administrator.healthlife.moudle.science.bean.InfoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/4.
 */

public class InfoAdapter extends BaseAdapter<InfoAdapter.InfoViewHolder> {
    ViewOnClickListener mViewOnClickListener;
    ArrayList<InfoBean.TngouBean> mTngouBean = new ArrayList<>();

    public InfoAdapter(ViewOnClickListener mViewOnClickListener, ArrayList<InfoBean.TngouBean> mTngouBean) {
        super(mViewOnClickListener);
        this.mViewOnClickListener = mViewOnClickListener;
        this.mTngouBean = mTngouBean;
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_info, null);
        InfoViewHolder infoViewHolder = new InfoViewHolder(view, mViewOnClickListener);
        return infoViewHolder;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        holder.ivImg.setImageURI(Uri.parse("http://tnfs.tngou.net/image" + mTngouBean.get(position).getImg()));
        holder.tvTitle.setText(mTngouBean.get(position).getTitle());
        holder.tvRead.setText("" + mTngouBean.get(position).getCount());
    }

    @Override
    public int getItemCount() {
        return mTngouBean.size();
    }

    public class InfoViewHolder extends BaseViewHolder {
        @BindView(R.id.iv_img)
        SimpleDraweeView ivImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_read)
        TextView tvRead;

        public InfoViewHolder(View itemView, ViewOnClickListener viewOnClickListener) {
            super(itemView, viewOnClickListener);
            ButterKnife.bind(this, itemView);
        }
    }
}
