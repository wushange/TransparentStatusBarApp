package com.wsg.transparentstatusbarapp.testfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.wsg.transparentstatusbarapp.BaseFragmentV4;
import com.wsg.transparentstatusbarapp.R;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class PersonFragment extends BaseFragmentV4 {

    @Override
    public int bindLayout() {
        return R.layout.fragment_person;
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
//        view.setPadding(0, getStatusBarHeight(getActivity()), 0, 0);
    }

    @Override
    public void doBusiness(Context mContext) {
    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }
}