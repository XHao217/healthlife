package com.example.administrator.healthlife.moudle.drug;

import android.view.View;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseLazyFragment;

/**
 * Created by Administrator on 2017/4/2.
 */

public class DrugFragment extends BaseLazyFragment{
    public static DrugFragment newInstance() {
        DrugFragment fragment = new DrugFragment();
        return fragment;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.fragment_drug;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void getData() {

    }
}
