package com.wsg.transparentstatusbarapp.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.wsg.transparentstatusbarapp.util.HideInputUtils;
import com.wsg.transparentstatusbarapp.util.StatusBarUtil;

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
    protected Operation mBaseOperation = null;//通用操作 dilog.toast...


    protected boolean autoDissIm = true;//是否自动检测点击屏幕边缘隐藏输入法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(mContextView);
        ButterKnife.bind(this);//注册黄油刀
        context = new WeakReference<Activity>(this);
        mBaseOperation = new Operation(this);//初始化通用操作
        initView(mContextView);//初始化视图
        doBusiness(this);//初始化操作


    }

    /**
     * 设置状态栏文字高亮显示
     *
     * @param isDark
     */
    public void setStausBarTextDeep(boolean isDark) {
        if (isDark == true) {
            StatusBarUtil.setStatusBarTextColor(this, true);
        } else {
            StatusBarUtil.setStatusBarTextColor(this, false);
        }

    }

    /**
     * 设置状态栏颜色
     *
     * @param color
     */

    public void setStatusColor(int color) {
        StatusBarUtil.setColor(this, color);
    }

    /**
     * 设置全屏模式透明
     */
    public void setTranslucentStatus() {
        StatusBarUtil.setTranslucentStatus(this, true);
    }

    /**
     * 设置全屏模式透明内容padding
     */
    public void setTranslucentStatusPadding() {
        StatusBarUtil.setTransparent(this);
    }

    /**
     * 注入Injector
     */
//    public abstract void initInjector();
//
//
//    protected ApplicationComponent getApplicationComponent() {
//        return ((MyApplication) getApplication()).getApplicationComponent();
//    }
//
//    protected ActivityModule getActivityModule() {
//        return new ActivityModule(this);
//    }
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

    public boolean isAutoDissIm() {
        return autoDissIm;
    }


    /**
     * 设置是否触摸关闭输入法
     *
     * @param autoDissIm
     */
    public void setAutoDissIm(boolean autoDissIm) {
        this.autoDissIm = autoDissIm;
    }


    protected Activity getContext() {
        if (null != context)
            return context.get();
        else
            return null;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (autoDissIm == true) {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if (HideInputUtils.isShouldHideInput(v, ev)) {

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
                return super.dispatchTouchEvent(ev);
            }
            if (getWindow().superDispatchTouchEvent(ev)) {
                return true;
            }

        } else {
            return super.dispatchTouchEvent(ev);
        }
        return onTouchEvent(ev);
    }

    public void initToolBar(Toolbar mToolBar) {
        if (null != mToolBar) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
