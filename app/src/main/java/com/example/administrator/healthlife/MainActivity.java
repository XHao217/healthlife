package com.example.administrator.healthlife;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.healthlife.base.BaseActivity;
import com.example.administrator.healthlife.bean.TabBean;
import com.example.administrator.healthlife.moudle.disease.DiseaseFragment;
import com.example.administrator.healthlife.moudle.drug.DrugFragment;
import com.example.administrator.healthlife.moudle.medical.MedicalFragment;
import com.example.administrator.healthlife.moudle.science.ScienceFragment;
import com.example.administrator.healthlife.widget.MainBottomTabLayout;
import com.example.administrator.healthlife.widget.MainViewPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.mainbottomTab)
    MainBottomTabLayout mainbottomTab;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void initData() {
        ButterKnife.bind(this);
        vpMain= (ViewPager) this.findViewById(R.id.vp_main);
        mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        mainbottomTab= (MainBottomTabLayout) findViewById(R.id.mainbottomTab);
        mainViewPagerAdapter.addFr(ScienceFragment.newInstance());
        mainViewPagerAdapter.addFr(DiseaseFragment.newInstance());
        mainViewPagerAdapter.addFr(MedicalFragment.newInstance());

        ArrayList<TabBean> arrayList=new ArrayList<TabBean>();
        arrayList.add(new TabBean("科普",R.mipmap.science_choose,R.mipmap.science_normal));
        arrayList.add(new TabBean("疾病用药",R.mipmap.disease_choose,R.mipmap.disease_normal));
        arrayList.add(new TabBean("医院查询",R.mipmap.hospital_choose,R.mipmap.hospital_normal));
        vpMain.setAdapter(mainViewPagerAdapter);
        vpMain.setOffscreenPageLimit(mainViewPagerAdapter.getCount());
        mainbottomTab.setViewPager(vpMain,arrayList);
    }

    @Override
    protected int getLayoutId() {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_main;
    }

    @Override
    protected void getData() {

    }

    long exitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime)>2000){
                Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
                exitTime=System.currentTimeMillis();
            }else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
