package com.wsg.transparentstatusbarapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

/**
 * 基类Activity
 *
 * @author wushange
 *         created at 2016/06/30 14:03
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {
    protected WeakReference<Activity> context = null;//弱引用
    protected View mContextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(mContextView);
        ButterKnife.bind(this);//注册黄油刀
        context = new WeakReference<Activity>(this);
        initView(mContextView);//初始化视图
        doBusiness(this);//初始化操作


    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    protected Activity getContext() {
        if (null != context)
            return context.get();
        else
            return null;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initToolBar(Toolbar mToolBar) {
        if (null != mToolBar) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
