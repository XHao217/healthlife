package com.example.administrator.healthlife.moudle.science.News;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseActivity;
import com.example.administrator.healthlife.moudle.science.bean.InfoBean;
import com.example.administrator.healthlife.widget.MainViewPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends BaseActivity {
    @BindView(R.id.back_news)
    ImageView backNews;
    @BindView(R.id.vp_newsdetail)
    ViewPager vpNewsdetail;
    MainViewPagerAdapter mainViewPagerAdapter;
    private ArrayList<InfoBean.TngouBean> mResultBeen=new ArrayList<>();

    @Override
    protected void initData() {
        mResultBeen=getIntent().getParcelableArrayListExtra("info");
    }

    @Override
    protected int getLayoutId() {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_news_deail;
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        backNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        for (int i=0;i<mResultBeen.size();i++){
            mainViewPagerAdapter.addFr(new NewsDetailFragment(mResultBeen.get(i)));
        }
        vpNewsdetail.setAdapter(mainViewPagerAdapter);
        vpNewsdetail.setCurrentItem(Integer.parseInt(getIntent().getStringExtra("position")));
    }
}
