package com.dream.bilibili.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.dream.bilibili.base.presenter.AbstractPresenter;
import com.dream.bilibili.base.view.BaseView;
import com.dream.bilibili.common.MyApplication;
import com.dream.bilibili.di.component.DaggerFragmentComponent;
import com.dream.bilibili.di.component.FragmentComponent;
import com.dream.bilibili.di.module.FragmentModule;
import com.dream.bilibili.util.CommonUtils;

import javax.inject.Inject;


/**
 * MVP模式的Base fragment
 *
 * @author quchao
 * @date 2017/11/28
 */

public abstract class BaseFragment<T extends AbstractPresenter> extends AbstractSimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }



    @Override
    public void showErrorMsg(String errorMsg) {
        if (isAdded()) {
            CommonUtils.showSnackMessage(_mActivity, errorMsg);
        }
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void reload() {

    }



    /**
     * 注入当前Fragment所需的依赖
     */
    protected abstract void initInject();

}
