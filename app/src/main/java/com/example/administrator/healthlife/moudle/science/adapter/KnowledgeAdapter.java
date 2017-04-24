package com.example.administrator.healthlife.moudle.science.adapter;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseAdapter;
import com.example.administrator.healthlife.base.BaseViewHolder;
import com.example.administrator.healthlife.moudle.science.bean.KnowledgeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/17.
 */

public class KnowledgeAdapter extends BaseAdapter<KnowledgeAdapter.KnowledgeViewHolder> {
    ViewOnClickListener mViewOnClickListener;
    ArrayList<KnowledgeBean.TngouBean> mResult = new ArrayList<>();

    public KnowledgeAdapter(ViewOnClickListener mViewOnClickListener, ArrayList<KnowledgeBean.TngouBean> mResult) {
        super(mViewOnClickListener);
        this.mViewOnClickListener = mViewOnClickListener;
        this.mResult = mResult;
    }

    @Override
    public KnowledgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_knowledge, null);
        KnowledgeViewHolder knowledgeViewHolder = new KnowledgeViewHolder(view, mViewOnClickListener);
        return knowledgeViewHolder;
    }

    @Override
    public void onBindViewHolder(KnowledgeViewHolder holder, int position) {
        holder.tvTitle.setText(mResult.get(position).getTitle());
        holder.ivImg.setImageURI(Uri.parse("http://tnfs.tngou.net/image"+mResult.get(position).getImg()));
        holder.tvRead.setText(""+mResult.get(position).getCount());
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    public class KnowledgeViewHolder extends BaseViewHolder {
        @BindView(R.id.iv_img)
        SimpleDraweeView ivImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.iv)
        SimpleDraweeView iv;
        @BindView(R.id.tv_read)
        TextView tvRead;
        @BindView(R.id.lv)
        LinearLayout lv;
        public KnowledgeViewHolder(View itemView, ViewOnClickListener viewOnClickListener) {
            super(itemView, viewOnClickListener);
            ButterKnife.bind(this, itemView);
        }
    }
}
