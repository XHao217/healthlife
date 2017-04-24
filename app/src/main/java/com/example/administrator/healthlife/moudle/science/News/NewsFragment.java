package com.example.administrator.healthlife.moudle.science.News;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.healthlife.MyApi;
import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.base.BaseAdapter;
import com.example.administrator.healthlife.base.BaseLazyFragment;
import com.example.administrator.healthlife.moudle.science.adapter.InfoAdapter;
import com.example.administrator.healthlife.moudle.science.bean.InfoBean;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/4/4.
 */

public class NewsFragment extends BaseLazyFragment {

    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    @BindView(R.id.sv_news)
    SpringView svNews;
    private int mindex=1;
    private ArrayList<InfoBean.TngouBean> mResultBeen=new ArrayList<>();
    private InfoAdapter mInfoAdapter;

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        mInfoAdapter=new InfoAdapter(new BaseAdapter.ViewOnClickListener() {
            @Override
            public void onClick(int position, View view) {
                Intent intent=new Intent(getContext(),NewsDetailActivity.class);
                intent.putParcelableArrayListExtra("info",mResultBeen);
                intent.putExtra("position",position+"");
                startActivity(intent);
            }
        },mResultBeen);
        rvNews.setAdapter(mInfoAdapter);
        svNews.setHeader(new DefaultHeader(getActivity()));
        svNews.setFooter(new DefaultFooter(getActivity()));
        getInfo();
        svNews.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mindex=1;
                mResultBeen.clear();
                getInfo();
            }

            @Override
            public void onLoadmore() {
                getInfo();
            }
        });
    }


    @Override
    protected void repeat() {
        super.repeat();
        mindex=1;
        getInfo();
    }

    @Override
    protected void getData() {

    }

    private void getInfo() {
        setState(StateCode.LODING);
        OkGo.get(MyApi.InfoListUrl)
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
                        if(mindex==1&&mResultBeen.isEmpty()){
                            if(mResultBeen!=null){
                                mResultBeen.clear();
                            }
                        }
                        Gson gson=new Gson();
                        InfoBean infoBean=gson.fromJson(s,InfoBean.class);
                        mResultBeen.addAll(infoBean.getTngou());
                        mInfoAdapter.notifyDataSetChanged();
                        svNews.onFinishFreshAndLoad();
                        mindex++;
                    }
                });
    }
}

