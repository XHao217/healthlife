package com.example.administrator.healthlife.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.healthlife.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/2.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter{
    ArrayList<BaseFragment> fragments=new ArrayList<>();
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFr(BaseFragment fr){
        fragments.add(fr);
    }
}
