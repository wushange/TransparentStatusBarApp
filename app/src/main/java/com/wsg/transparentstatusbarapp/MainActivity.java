package com.wsg.transparentstatusbarapp;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.githang.viewpagerindicator.IconPagerAdapter;
import com.githang.viewpagerindicator.IconTabPageIndicator;
import com.wsg.transparentstatusbarapp.testfragment.CityFragment;
import com.wsg.transparentstatusbarapp.testfragment.HomeFragment;
import com.wsg.transparentstatusbarapp.testfragment.MessageFragment;
import com.wsg.transparentstatusbarapp.testfragment.PersonFragment;

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {

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

        CityFragment cityFragment = new CityFragment();
        cityFragment.initIconWithText("模块1", R.drawable.tab_user_selector);
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.initIconWithText("模块2", R.drawable.tab_user_selector);
        MessageFragment messageFragment = new MessageFragment();
        messageFragment.initIconWithText("模块3", R.drawable.tab_user_selector);
        PersonFragment personFragment = new PersonFragment();
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
