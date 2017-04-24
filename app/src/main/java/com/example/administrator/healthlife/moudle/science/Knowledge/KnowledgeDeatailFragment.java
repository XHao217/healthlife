package com.example.administrator.healthlife.moudle.science.Knowledge;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseFragment;
import com.example.administrator.healthlife.moudle.science.bean.KnowledgeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/18.
 */

public class KnowledgeDeatailFragment extends BaseFragment {
    @BindView(R.id.title_knowdetail)
    TextView titleKnowdetail;
    @BindView(R.id.tv_read)
    TextView tvRead;
    @BindView(R.id.iv_knowdetail)
    SimpleDraweeView ivKnowdetail;
    @BindView(R.id.tv)
    TextView tv;
    KnowledgeBean.TngouBean mdata;

    public KnowledgeDeatailFragment( KnowledgeBean.TngouBean mdata){
        this.mdata=mdata;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.item_knowledgedetail;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
        titleKnowdetail.setText(mdata.getTitle());
        tvRead.setText(""+mdata.getCount());
        ivKnowdetail.setImageURI(Uri.parse("http://tnfs.tngou.net/image"+mdata.getImg()));
        tv.setText(mdata.getDescription());
    }

    @Override
    protected void getData() {

    }

}
