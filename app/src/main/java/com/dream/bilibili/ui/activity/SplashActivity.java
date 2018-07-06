package com.dream.bilibili.ui.activity;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dream.bilibili.R;
import com.dream.bilibili.base.activity.BaseActivity;
import com.dream.bilibili.contract.SplashContract;
import com.dream.bilibili.presenter.SplashPresenter;
import com.dream.bilibili.util.CommonUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Administrator
 * @date 2018/7/6
 */

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {


    @BindView(R.id.tv_count_down)
    TextView mTvCountDown;
    @BindView(R.id.ll_count_down)
    LinearLayout mLlCountDown;


    @BindView(R.id.normal_view)
    ConstraintLayout mContentView;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.splash();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

    }

    @Override
    protected boolean isHideToolbar() {
        return true;
    }

    @OnClick(R.id.ll_count_down)
    public void onClick() {
       toMainActivity();
    }

    @Override
    public void showCountDown(long countDownTime) {
        mTvCountDown.setText(CommonUtils.valueOf(countDownTime));
    }

    @Override
    public void toMainActivity() {
        LoginActivity.start(mActivity);
        finish();
    }


}
