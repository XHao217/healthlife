package com.example.administrator.healthlife.moudle.disease.One;

import android.view.View;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseLazyFragment;

/**
 * Created by Administrator on 2017/4/19.
 */

public class OneFragment extends BaseLazyFragment{

    public static OneFragment newInstance(){
        OneFragment fragment=new OneFragment();
        return fragment;
    }
    @Override
    protected int getLaytoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void getData() {

    }
}
