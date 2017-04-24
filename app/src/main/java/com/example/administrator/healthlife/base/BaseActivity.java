package com.example.administrator.healthlife.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/4/2.
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBaseActivity();
    }

    private void initBaseActivity() {
        setContentView(getLayoutId());
        initData();
        getData();
    }

    protected abstract void initData();

    protected abstract int getLayoutId();

    protected abstract void getData();
}
