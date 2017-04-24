package com.example.administrator.healthlife.moudle.science.Recipe;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseFragment;
import com.example.administrator.healthlife.moudle.science.bean.RecipeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/15.
 */

public class RecipeDetailFragment extends BaseFragment {
    RecipeBean.TngouBean mdata;
    @BindView(R.id.iv_recipedetail)
    SimpleDraweeView ivRecipedetail;
    @BindView(R.id.title_recipedetail)
    TextView titleRecipedetail;

    public RecipeDetailFragment(RecipeBean.TngouBean mdata) {
        this.mdata = mdata;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.item_recipedetail;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
        ivRecipedetail.setImageURI(Uri.parse("http://tnfs.tngou.net/image"+mdata.getImg()));
        titleRecipedetail.setText(mdata.getDescription()+"");
    }

    @Override
    protected void getData() {

    }

}
