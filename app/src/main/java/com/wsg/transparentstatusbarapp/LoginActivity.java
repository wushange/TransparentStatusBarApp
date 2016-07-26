package com.wsg.transparentstatusbarapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import butterknife.BindView;

/**
 * Created by wushange on 2016/07/26.
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    public int bindLayout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        return R.layout.test;
    }

    @Override
    public void initView(View view) {
        view.setPadding(0, ResourceUtils.getStatusBarHeight(this), 0, 0);
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
