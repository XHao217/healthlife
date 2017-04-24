package com.example.administrator.healthlife.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.healthlife.R;
import com.example.administrator.healthlife.bean.TabBean;

/**
 * Created by Administrator on 2017/4/2.
 */

public class BottomTab extends LinearLayout{
    TextView tvTitle;
    ImageView ivIcon;
    TabBean mTabBean;

    public BottomTab(Context context,TabBean tabBean) {
        super(context);
        setOrientation(HORIZONTAL);
        mTabBean=tabBean;
        init();
    }

    private void init() {
        LinearLayout linearLayout=new LinearLayout(getContext());
        LayoutParams lllayoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(lllayoutParams);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);

        ivIcon=new ImageView(getContext());
        int size= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,
                getContext().getResources().getDisplayMetrics());
        LayoutParams iconLayoutParams=new LayoutParams(size,size);
        ivIcon.setLayoutParams(iconLayoutParams);
        ivIcon.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ivIcon.setImageResource(mTabBean.getIconNormalResId());
        linearLayout.addView(ivIcon);

        tvTitle=new TextView(getContext());
        tvTitle.setGravity(Gravity.CENTER);
        LayoutParams titleLayoutParams=new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tvTitle.setLayoutParams(titleLayoutParams);
        tvTitle.setText(mTabBean.getTitle()==null ? "默认" : mTabBean.getTitle());
        tvTitle.setTextColor(ContextCompat.getColor(getContext(), R.color.main_gray));
        linearLayout.addView(tvTitle);

        addView(linearLayout);
    }

    public BottomTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setSelected(boolean selected) {
        if(selected){
            if(null != tvTitle){
                tvTitle.setTextColor(ContextCompat.getColor(getContext(),R.color.blue));
            }
            if (null !=ivIcon){
                ivIcon.setImageResource(mTabBean.getIconChooseResId());
            }
        }else {
            if(null != tvTitle){
                tvTitle.setTextColor(ContextCompat.getColor(getContext(),R.color.gray));
            }
            if (null !=ivIcon){
                ivIcon.setImageResource(mTabBean.getIconNormalResId());
            }
        }
    }
}
