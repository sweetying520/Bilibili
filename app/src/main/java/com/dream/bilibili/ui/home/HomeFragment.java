package com.dream.bilibili.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dream.bilibili.R;
import com.dream.bilibili.base.fragment.AbstractRootFragment;
import com.dream.bilibili.common.MyConstants;
import com.dream.bilibili.contract.HomeContract;
import com.dream.bilibili.presenter.HomePresenter;
import com.dream.bilibili.ui.activity.MainActivity;
import com.dream.bilibili.util.CommonUtils;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Administrator
 * @date 2018/7/6
 */

public class HomeFragment extends AbstractRootFragment<HomePresenter> implements HomeContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private MainActivity mainActivity;
    @BindView(R.id.tab_home)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.normal_view)
    ViewPager mViewPager;



    public static HomeFragment getInstance(String params1, String params2) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MyConstants.PARAMS_ONE, params1);
        bundle.putString(MyConstants.PARAMS_TWO, params2);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_game:
                break;
            case R.id.menu_download:
                break;
            case R.id.menu_search:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        initToolbar();

        initFragment();
    }

    private void initFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        String[] titles = new String[]{CommonUtils.getString(R.string.live),CommonUtils.getString(R.string.recommend),CommonUtils.getString(R.string.zf),
        CommonUtils.getString(R.string.partition),CommonUtils.getString(R.string.trend),CommonUtils.getString(R.string.discovery)};
        fragmentList.add(LiveFragment.getInstance(null, null));
        fragmentList.add(LiveFragment.getInstance(null, null));
        fragmentList.add(LiveFragment.getInstance(null, null));
        fragmentList.add(LiveFragment.getInstance(null, null));
        fragmentList.add(LiveFragment.getInstance(null, null));
        fragmentList.add(LiveFragment.getInstance(null, null));
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        mSlidingTabLayout.setViewPager(mViewPager);
    }

    private void initToolbar() {
        mToolbar.setTitle("");
        mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.menu_main);
    }



    @OnClick(R.id.ll_navigation)
    public void onClick() {
        mainActivity.openDrawerlayout();
    }
}
