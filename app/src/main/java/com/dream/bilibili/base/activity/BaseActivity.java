package com.dream.bilibili.base.activity;

import com.dream.bilibili.base.presenter.AbstractPresenter;
import com.dream.bilibili.base.view.BaseView;
import com.dream.bilibili.common.MyApplication;
import com.dream.bilibili.di.component.ActivityComponent;
import com.dream.bilibili.di.component.DaggerActivityComponent;
import com.dream.bilibili.di.module.ActivityModule;
import com.dream.bilibili.util.CommonUtils;

import javax.inject.Inject;


/**
 * MVP模式的Base Activity
 *
 * @author quchao
 * @date 2017/11/28
 */

public abstract class BaseActivity<T extends AbstractPresenter> extends AbstractSimpleActivity implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }


    @Override
    public void showErrorMsg(String errorMsg) {
        CommonUtils.showSnackMessage(this, errorMsg);
    }

    @Override
    public void showNormal() {
        showNormalView();
    }

    @Override
    public void showError() {
        showErrorView();
    }

    @Override
    public void showLoading() {
        showLoadingView();
    }

    @Override
    public void reload() {

    }




    /**
     * 注入当前Activity所需的依赖
     */
    protected abstract void initInject();

}
