package com.example.administrator.healthlife.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.administrator.healthlife.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/2.
 */

public abstract class BaseLazyFragment extends BaseFragment {
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.rootViewError)
    LinearLayout rootViewError;

    private boolean isViewInit=false;
    private boolean isVisible=false;
    private boolean isLoad=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.fragment_state, container, false);
        FrameLayout rootView = (FrameLayout) view.findViewById(R.id.rootView);
        View childView = LayoutInflater.from(getActivity()).inflate(getLaytoutId(), rootView, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootView.addView(childView, layoutParams);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBase(view);
    }

    @Override
    protected void initBase(View view) {
        rootViewError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeat();
            }
        });
        initData();
    }

    protected void repeat(){
    }

    public class StateCode{
        public final static int CONTENT=1;
        public final static int ERROR=2;
        public final static int LODING=3;
    }

    protected void setState(int state){
        if(state==StateCode.CONTENT){
            progressBar.setVisibility(View.GONE);
            rootViewError.setVisibility(View.GONE);
        }
        if(state==StateCode.ERROR){
            progressBar.setVisibility(View.GONE);
            rootViewError.setVisibility(View.VISIBLE);
        }
        if(state==StateCode.LODING){
            progressBar.setVisibility(View.VISIBLE);
            rootViewError.setVisibility(View.GONE);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(isVisible&&isLoad){
            initView(getView());
            getData();
            isLoad=false;
        }
        isViewInit=true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisible=isVisibleToUser;
        if(isViewInit&&isVisible&&isLoad){
            initView(getView());
            getData();
            isLoad=false;
        }
    }
}
