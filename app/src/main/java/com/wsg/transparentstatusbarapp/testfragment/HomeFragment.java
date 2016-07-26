package com.wsg.transparentstatusbarapp.testfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wsg.transparentstatusbarapp.BaseFragmentV4;
import com.wsg.transparentstatusbarapp.LoginActivity;
import com.wsg.transparentstatusbarapp.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class HomeFragment extends BaseFragmentV4 {

    @BindView(R.id.bt_login)
    Button login;

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        view.setPadding(0, getStatusBarHeight(getActivity()), 0, 0);
    }

    @Override
    public void doBusiness(Context mContext) {
    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }

    @OnClick(R.id.bt_login)
    public void setLogin(View v) {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}