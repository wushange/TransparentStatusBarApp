package com.wsg.transparentstatusbarapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.githang.viewpagerindicator.IconPagerAdapter;
import com.githang.viewpagerindicator.IconTabPageIndicator;
import com.wsg.transparentstatusbarapp.base.BaseActivity;
import com.wsg.transparentstatusbarapp.base.BaseFragmentV4;
import com.wsg.transparentstatusbarapp.testfragment.Test1Fragment;
import com.wsg.transparentstatusbarapp.testfragment.Test2Fragment;
import com.wsg.transparentstatusbarapp.testfragment.TestPaddingfFragment;
import com.wsg.transparentstatusbarapp.testfragment.Test4Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.indicator)
    IconTabPageIndicator mIndicator;


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        setTranslucentStatus();
        initFragments();
        initViews();
    }

    private void initViews() {
        List<BaseFragmentV4> fragments = initFragments();
        FragmentAdapter adapter = new FragmentAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mIndicator.setViewPager(mViewPager);
    }

    private List<BaseFragmentV4> initFragments() {
        List<BaseFragmentV4> fragments = new ArrayList<BaseFragmentV4>();

        Test1Fragment cityFragment = new Test1Fragment();
        cityFragment.initIconWithText("模块1", R.drawable.tab_user_selector);
        Test2Fragment homeFragment = new Test2Fragment();
        homeFragment.initIconWithText("模块2", R.drawable.tab_user_selector);
        TestPaddingfFragment messageFragment = new TestPaddingfFragment();
        messageFragment.initIconWithText("模块3", R.drawable.tab_user_selector);
        Test4Fragment personFragment = new Test4Fragment();
        personFragment.initIconWithText("模块3", R.drawable.tab_user_selector);
        fragments.add(cityFragment);
        fragments.add(homeFragment);
        fragments.add(messageFragment);
        fragments.add(personFragment);
        return fragments;
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    class FragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
        private List<BaseFragmentV4> mFragments;

        public FragmentAdapter(List<BaseFragmentV4> fragments, FragmentManager fm) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getIconResId(int index) {
            return mFragments.get(index).getIconId();
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getTitle();
        }
    }
}
