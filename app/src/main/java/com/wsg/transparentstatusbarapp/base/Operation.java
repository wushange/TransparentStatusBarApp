package com.wsg.transparentstatusbarapp.base;

import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

import com.wsg.transparentstatusbarapp.MyApplication;


/**
 * 基本的操作共通抽取
 * Created by wushange on  2016/06/30.
 */
public class Operation {
    /***
     * Activity之间数据传输数据对象Key
     **/
    public final String ACTIVITY_DTO_KEY = "ACTIVITY_DTO_KEY";
    /**
     * 激活Activity组件意图
     **/
    private Intent mIntent = new Intent();
    /***
     * 上下文
     **/
    private Activity mContext = null;
    /***
     * 整个应用Applicaiton
     **/
    private MyApplication mApplication = null;
    private boolean isShow = true;
    private Toast mToast;

    public Operation(Activity mContext) {
        this.mContext = mContext;
        mApplication = (MyApplication) this.mContext.getApplicationContext();
    }

    /**
     * 跳转Activity
     *
     * @param activity 需要跳转至的Activity
     */
    public void forward(Class<? extends Activity> activity) {
        mIntent.setClass(mContext, activity);
        mContext.startActivity(mIntent);
    }





    /***
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * *
     * ToastUtil                                                   *
     * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */

    public void showToast(CharSequence text) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public void EmptyToast() {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, "不允许为空！", Toast.LENGTH_SHORT);
        } else {
            mToast.setText("不允许为空！");
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public void showToastInCenter(String msg) {
        Toast toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

}
