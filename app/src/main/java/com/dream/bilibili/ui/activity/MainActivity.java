package com.dream.bilibili.ui.activity;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;

import com.dream.bilibili.R;
import com.dream.bilibili.base.activity.BaseActivity;
import com.dream.bilibili.contract.MainContract;
import com.dream.bilibili.presenter.MainPresenter;
import com.dream.bilibili.ui.fragment.HomeFragment;
import com.dream.bilibili.util.CommonUtils;
import com.dream.bilibili.util.StatusBarUtils;

import butterknife.BindView;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.normal_view)
    DrawerLayout mDrawerLayout;

    public static void start(Context mContext) {
        CommonUtils.toActivity(mContext, MainActivity.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main_content, HomeFragment.getInstance(null,null)).commitNowAllowingStateLoss();
    }

    @Override
    protected void setStatusbarColor() {
        StatusBarUtils.setColorNoTranslucentForDrawerLayout(mActivity,mDrawerLayout,CommonUtils.getColor(R.color.colorPrimary));
    }

    @Override
    protected boolean isHideToolbar() {
        return true;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}
