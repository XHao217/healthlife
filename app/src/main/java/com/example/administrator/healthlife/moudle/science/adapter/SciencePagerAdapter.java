package com.example.administrator.healthlife.moudle.science.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.healthlife.moudle.science.bean.ScienceTabBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/4.
 */

public class SciencePagerAdapter extends FragmentPagerAdapter{
    ArrayList<ScienceTabBean> mFragments=new ArrayList<>();
    public SciencePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position).getFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void addFr(ArrayList<ScienceTabBean> fragments){
        mFragments.addAll(fragments);
    }
}
