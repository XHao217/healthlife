package com.example.administrator.healthlife.moudle.science;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseLazyFragment;
import com.example.administrator.healthlife.moudle.science.Knowledge.KnowledgeFragment;
import com.example.administrator.healthlife.moudle.science.News.NewsFragment;
import com.example.administrator.healthlife.moudle.science.Recipe.RecipeFragment;
import com.example.administrator.healthlife.moudle.science.adapter.SciencePagerAdapter;
import com.example.administrator.healthlife.moudle.science.bean.ScienceTabBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import shanyao.tabpagerindictor.TabPageIndicator;

/**
 * Created by Administrator on 2017/4/2.
 */

public class ScienceFragment extends BaseLazyFragment {
    @BindView(R.id.t1_science)
    TabPageIndicator t1Science;
    @BindView(R.id.vp_science)
    ViewPager vpScience;
    private ArrayList<ScienceTabBean> tabBeen=new ArrayList<>();
    private SciencePagerAdapter sciencePagerAdapter;

    public static ScienceFragment newInstance() {
        ScienceFragment fragment = new ScienceFragment();
        return fragment;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.fragment_science;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        setState(StateCode.CONTENT);
        tabBeen.add(new ScienceTabBean("健康资讯", NewsFragment.newInstance()));
        tabBeen.add(new ScienceTabBean("健康知识", KnowledgeFragment.newInstance()));
        tabBeen.add(new ScienceTabBean("健康菜谱", RecipeFragment.newInstance()));
        sciencePagerAdapter=new SciencePagerAdapter(getChildFragmentManager());
        sciencePagerAdapter.addFr(tabBeen);
        vpScience.setAdapter(sciencePagerAdapter);
        vpScience.setOffscreenPageLimit(sciencePagerAdapter.getCount());
        t1Science.setViewPager(vpScience);
        setTabpager();
    }

    @Override
    protected void getData() {

    }

    private void setTabpager(){
        t1Science.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_NOWEIGHT_EXPAND_SAME);
        t1Science.setDividerColor(Color.parseColor("#969696"));
        t1Science.setDividerPadding(10);
        t1Science.setIndicatorColor(Color.parseColor("#1485E5"));
        t1Science.setTextColorSelected(Color.parseColor("#1296db"));
        t1Science.setTextColor(Color.parseColor("#000000"));
        t1Science.setTextSize(30);
    }
}
