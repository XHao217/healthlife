package com.example.administrator.healthlife.moudle.science.Recipe;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.healthlife.MyApi;
import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseAdapter;
import com.example.administrator.healthlife.base.BaseLazyFragment;
import com.example.administrator.healthlife.moudle.science.adapter.RecipeAdapter;
import com.example.administrator.healthlife.moudle.science.bean.RecipeBean;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/4/4.
 */

public class RecipeFragment extends BaseLazyFragment {
    @BindView(R.id.rv_recipe)
    RecyclerView rvRecipe;
    @BindView(R.id.sv_recipe)
    SpringView svRecipe;
    private int mindex=1;
    private ArrayList<RecipeBean.TngouBean> mResultBeen = new ArrayList<>();
    private RecipeAdapter mRecipeAdapter;

    public static RecipeFragment newInstance() {
        RecipeFragment fragment = new RecipeFragment();
        return fragment;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.fragment_recipe;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        rvRecipe.setPadding(10,10,10,10);
        rvRecipe.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rvRecipe.addItemDecoration(new SpacesItemDecoration(20));
        mRecipeAdapter=new RecipeAdapter(new BaseAdapter.ViewOnClickListener() {
            @Override
            public void onClick(int position, View view) {
                Intent intent=new Intent(getContext(),RecipeDetailActivity.class);
                intent.putParcelableArrayListExtra("recipe",mResultBeen);
                intent.putExtra("position",position+"");
                startActivity(intent);
            }
        },mResultBeen);
        rvRecipe.setAdapter(mRecipeAdapter);
        svRecipe.setHeader(new DefaultHeader(getActivity()));
        svRecipe.setFooter(new DefaultFooter(getActivity()));
        getRecipe();
        svRecipe.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mindex=1;
                mResultBeen.clear();
                getRecipe();
            }

            @Override
            public void onLoadmore() {
                getRecipe();
            }
        });
    }

    @Override
    protected void getData() {
    }

    @Override
    protected void repeat() {
        super.repeat();
        mindex=1;
        getRecipe();
    }

    private void getRecipe(){
        setState(StateCode.LODING);
        OkGo.get(MyApi.CookListURL)
                .params("page",mindex+"")
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        setState(StateCode.ERROR);
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        setState(StateCode.CONTENT);
                        if(mindex==1&& mResultBeen.isEmpty()){
                            if(mResultBeen!=null){
                                mResultBeen.clear();
                            }
                        }
                        Gson gson=new Gson();
                        RecipeBean recipeBean=gson.fromJson(s,RecipeBean.class);
                        mResultBeen.addAll(recipeBean.getTngou());
                        mRecipeAdapter.notifyDataSetChanged();
                        svRecipe.onFinishFreshAndLoad();
                        mindex++;
                    }
                });
    }


    private class SpacesItemDecoration extends RecyclerView.ItemDecoration{
        private int space;
        public SpacesItemDecoration(int space){
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left=space;
            outRect.bottom=space;
            outRect.top=space;
            outRect.right=space;
        }
    }
}

