package com.example.administrator.healthlife.moudle.science.News;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseFragment;
import com.example.administrator.healthlife.moudle.science.bean.InfoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/18.
 */

public class NewsDetailFragment extends BaseFragment {
    InfoBean.TngouBean mdata;
    @BindView(R.id.title_newsdetail)
    TextView titleNewsdetail;
    @BindView(R.id.tv_read)
    TextView tvRead;
    @BindView(R.id.iv_newsdetail)
    SimpleDraweeView ivNewsdetail;
    @BindView(R.id.tv)
    TextView tv;

    public NewsDetailFragment(InfoBean.TngouBean mdata) {
        this.mdata=mdata;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.item_newsdetail;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
        titleNewsdetail.setText(mdata.getTitle());
        tvRead.setText(""+mdata.getCount());
        ivNewsdetail.setImageURI(Uri.parse("http://tnfs.tngou.net/image"+mdata.getImg()));
        tv.setText(mdata.getDescription()+"");
    }

    @Override
    protected void getData() {

    }

}
