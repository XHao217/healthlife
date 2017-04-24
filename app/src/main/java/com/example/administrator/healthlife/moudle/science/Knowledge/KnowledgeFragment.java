package com.example.administrator.healthlife.moudle.science.Knowledge;

import android.content.Intent;
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
import com.example.administrator.healthlife.moudle.science.adapter.KnowledgeAdapter;
import com.example.administrator.healthlife.moudle.science.bean.InfoBean;
import com.example.administrator.healthlife.moudle.science.bean.KnowledgeBean;
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

public class KnowledgeFragment extends BaseLazyFragment {
    @BindView(R.id.rv_knowledge)
    RecyclerView rvKnowledge;
    @BindView(R.id.sv_knowledge)
    SpringView svKnowledge;
    private int mindex=1;
    private ArrayList<KnowledgeBean.TngouBean> mResultBeen=new ArrayList<>();
    private KnowledgeAdapter mKnowledgeAdapter;

    public static KnowledgeFragment newInstance() {
        KnowledgeFragment fragment = new KnowledgeFragment();
        return fragment;
    }

    @Override
    protected int getLaytoutId() {
        return R.layout.fragment_knowledge;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        rvKnowledge.setLayoutManager(new LinearLayoutManager(getActivity()));
        mKnowledgeAdapter=new KnowledgeAdapter(new BaseAdapter.ViewOnClickListener() {
            @Override
            public void onClick(int position, View view) {
                Intent intent=new Intent(getContext(),KnowledgeDetailActivity.class);
                intent.putParcelableArrayListExtra("know",mResultBeen);
                intent.putExtra("position",position+"");
                startActivity(intent);
            }
        },mResultBeen);
        rvKnowledge.setAdapter(mKnowledgeAdapter);
        svKnowledge.setHeader(new DefaultHeader(getActivity()));
        svKnowledge.setFooter(new DefaultFooter(getActivity()));
        getKnowledge();
        svKnowledge.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mindex=1;
                mResultBeen.clear();
                getKnowledge();
            }

            @Override
            public void onLoadmore() {
                getKnowledge();
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
        getKnowledge();
    }

    private void getKnowledge() {
        setState(StateCode.LODING);
        OkGo.get(MyApi.KnowListUrl)
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
                        KnowledgeBean knowledgeBean=gson.fromJson(s,KnowledgeBean.class);
                        mResultBeen.addAll(knowledgeBean.getTngou());
                        mKnowledgeAdapter.notifyDataSetChanged();
                        svKnowledge.onFinishFreshAndLoad();
                        mindex++;
                    }
                });
    }
}
