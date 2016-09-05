package com.wsg.transparentstatusbarapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wsg.transparentstatusbarapp.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by wushange on 2016/07/26.
 */
public class TestActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    public int bindLayout() {
        return R.layout.test;
    }

    @Override
    public void initView(View view) {
        setTranslucentStatusPadding();
        initToolBar(toolbar);
        setTitle("登陆");
        //设置toolbar透明
        Drawable d = toolbar.getBackground();
        d.setAlpha(0); // 完全に透明
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
