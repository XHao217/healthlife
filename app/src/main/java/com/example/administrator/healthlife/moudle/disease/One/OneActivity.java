package com.example.administrator.healthlife.moudle.disease.One;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseActivity;
import com.example.administrator.healthlife.widget.MainViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OneActivity extends BaseActivity {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    private MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void initData() {
        ButterKnife.bind(this);
        mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFr(OneFragment.newInstance());
        vpMain.setAdapter(mainViewPagerAdapter);
        vpMain.setOffscreenPageLimit(mainViewPagerAdapter.getCount());
    }

    @Override
    protected int getLayoutId() {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_one;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
