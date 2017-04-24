package com.example.administrator.healthlife.moudle.medical;

import android.view.View;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseLazyFragment;

/**
 * Created by Administrator on 2017/4/2.
 */

public class MedicalFragment extends BaseLazyFragment{
    public static MedicalFragment newInstance() {
        MedicalFragment fragment = new MedicalFragment();
        return fragment;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.fragment_medical;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void getData() {

    }
}
