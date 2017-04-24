package com.example.administrator.healthlife.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.healthlife.bean.TabBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/2.
 */

public class MainBottomTabLayout extends LinearLayout{
    private static final String TAG=MainBottomTabLayout.class.toString();
    ViewPager mViewPager;
    public MainBottomTabLayout(Context context) {
        this(context,null);
    }

    public MainBottomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MainBottomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setViewPager(ViewPager viewPager, ArrayList<TabBean> tabBeen){
        this.mViewPager=viewPager;
        initTabView(tabBeen);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG,"onPageScrolled"+position+""+positionOffset+""+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG,"onPageSelected"+position+"");
                for(int i=0;i<getChildCount();i++){
                    getChildAt(i).setSelected(position == i ? true : false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e(TAG,"onPageScrollStateChanged"+state+"");
            }
        });
    }

    class TabClick implements OnClickListener{
        TabBean tabBean;
        public TabClick(TabBean tabBean){
            this.tabBean=tabBean;
        }
        @Override
        public void onClick(View view) {
            mViewPager.setCurrentItem(tabBean.getIndex());
        }
    }

    BottomTab otherView;
    private void initTabView(ArrayList<TabBean> tabBeen) {
        int index=0;
        for (int i=0;i<tabBeen.size();i++){
            tabBeen.get(i).setIndex(index++);
        }
        for(int i=0;i<tabBeen.size();i++){
            BottomTab bottomTab=new BottomTab(getContext(),tabBeen.get(i));
            bottomTab.setOnClickListener(new TabClick(tabBeen.get(i)));
            LayoutParams layoutParams=new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.weight=1;
            layoutParams.gravity= Gravity.CENTER;
            addView(bottomTab,layoutParams);
            if(i==mViewPager.getCurrentItem()){
                bottomTab.setSelected(true);
            }
        }
    }
}
