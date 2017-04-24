package com.example.administrator.healthlife.moudle.science.Recipe;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseActivity;
import com.example.administrator.healthlife.moudle.science.bean.RecipeBean;
import com.example.administrator.healthlife.widget.MainViewPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/15.
 */

public class RecipeDetailActivity extends BaseActivity {
    @BindView(R.id.back_recipe)
    ImageView backRecipe;
    @BindView(R.id.vp_recipedetail)
    ViewPager vpRecipedetail;
    @BindView(R.id.activity_recipe_detail)
    LinearLayout activityRecipeDetail;
    MainViewPagerAdapter mainViewPagerAdapter;
    private ArrayList<RecipeBean.TngouBean> mResultBeen = new ArrayList<>();

    @Override
    protected void initData() {
        mResultBeen=getIntent().getParcelableArrayListExtra("recipe");
    }

    @Override
    protected int getLayoutId() {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_recipe_detail;
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        backRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        for (int i=0;i<mResultBeen.size();i++){
            mainViewPagerAdapter.addFr(new RecipeDetailFragment(mResultBeen.get(i)));
        }
        vpRecipedetail.setAdapter(mainViewPagerAdapter);
        vpRecipedetail.setCurrentItem(Integer.parseInt(getIntent().getStringExtra("position")));
    }
}
