package com.example.administrator.healthlife.moudle.disease;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseLazyFragment;
import com.example.administrator.healthlife.moudle.disease.One.OneActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/2.
 */

public class DiseaseFragment extends BaseLazyFragment {
    @BindView(R.id.rv1)
    RelativeLayout rv1;
    @BindView(R.id.lv1)
    LinearLayout lv1;
    @BindView(R.id.lv2)
    LinearLayout lv2;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.lv3)
    LinearLayout lv3;
    @BindView(R.id.rv2)
    RelativeLayout rv2;
    @BindView(R.id.lv4)
    LinearLayout lv4;
    @BindView(R.id.lv5)
    LinearLayout lv5;
    @BindView(R.id.rv3)
    RelativeLayout rv3;

    public static DiseaseFragment newInstance() {
        DiseaseFragment fragment = new DiseaseFragment();
        return fragment;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.fragment_disease;
    }

    @Override
    protected void initView(View view) {
        setState(StateCode.CONTENT);
    }

    @Override
    protected void getData() {

    }

    @OnClick({R.id.lv1, R.id.lv2, R.id.lv3, R.id.lv4, R.id.lv5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lv1:
                Intent intent1=new Intent(getActivity(),OneActivity.class);
                startActivity(intent1);
                break;
            case R.id.lv2:
                Intent intent2=new Intent(getActivity(),TwoActivity.class);
                startActivity(intent2);
                break;
            case R.id.lv3:
                Intent intent3=new Intent(getActivity(),ThreeActivity.class);
                startActivity(intent3);
                break;
            case R.id.lv4:
                Intent intent4=new Intent(getActivity(),FourActivity.class);
                startActivity(intent4);
                break;
            case R.id.lv5:
                Intent intent5=new Intent(getActivity(),FiveActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
