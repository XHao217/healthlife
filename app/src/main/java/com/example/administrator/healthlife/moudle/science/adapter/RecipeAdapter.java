package com.example.administrator.healthlife.moudle.science.adapter;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseAdapter;
import com.example.administrator.healthlife.base.BaseViewHolder;
import com.example.administrator.healthlife.moudle.science.bean.RecipeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/8.
 */

public class RecipeAdapter extends BaseAdapter<RecipeAdapter.RecipeViewHolder> {
    ViewOnClickListener mViewOnClickListener;
    ArrayList<RecipeBean.TngouBean> mResult = new ArrayList<>();

    public RecipeAdapter(ViewOnClickListener mViewOnClickListener, ArrayList<RecipeBean.TngouBean> mResult) {
        super(mViewOnClickListener);
        this.mViewOnClickListener = mViewOnClickListener;
        this.mResult = mResult;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_recipe, null);
        RecipeViewHolder recipeViewHolder = new RecipeViewHolder(view, mViewOnClickListener);
        return recipeViewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        holder.tvRecipe.setText(mResult.get(position).getName());
        holder.ivRecipe.setImageURI(Uri.parse("http://tnfs.tngou.net/image"+mResult.get(position).getImg()));
        holder.tvKeywords.setText(mResult.get(position).getKeywords());
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    public class RecipeViewHolder extends BaseViewHolder {
        @BindView(R.id.iv_recipe)
        SimpleDraweeView ivRecipe;
        @BindView(R.id.tv_recipe)
        TextView tvRecipe;
        @BindView(R.id.tv_keywords)
        TextView tvKeywords;

        public RecipeViewHolder(View itemView, ViewOnClickListener viewOnClickListener) {
            super(itemView, viewOnClickListener);
            ButterKnife.bind(this, itemView);
            ViewGroup.LayoutParams params=ivRecipe.getLayoutParams();
            params.height= (int) (200+Math.random()*220);
            ivRecipe.setLayoutParams(params);
        }
    }
}
