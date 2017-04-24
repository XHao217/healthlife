package com.example.administrator.healthlife.moudle.science.Knowledge;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseActivity;
import com.example.administrator.healthlife.moudle.science.News.NewsDetailFragment;
import com.example.administrator.healthlife.moudle.science.bean.KnowledgeBean;
import com.example.administrator.healthlife.widget.MainViewPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnowledgeDetailActivity extends BaseActivity {
    @BindView(R.id.back_know)
    ImageView backKnow;
    @BindView(R.id.vp_knowdetail)
    ViewPager vpKnowdetail;
    MainViewPagerAdapter mainViewPagerAdapter;
    private ArrayList<KnowledgeBean.TngouBean> mResultBeen=new ArrayList<>();

    @Override
    protected void initData() {
        mResultBeen=getIntent().getParcelableArrayListExtra("know");
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected int getLayoutId() {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_knowledge_detail;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        backKnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        for (int i=0;i<mResultBeen.size();i++){
            mainViewPagerAdapter.addFr(new KnowledgeDeatailFragment(mResultBeen.get(i)));
        }
        vpKnowdetail.setAdapter(mainViewPagerAdapter);
        vpKnowdetail.setCurrentItem(Integer.parseInt(getIntent().getStringExtra("position")));
    }
}
