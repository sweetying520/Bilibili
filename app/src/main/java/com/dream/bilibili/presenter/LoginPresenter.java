package com.dream.bilibili.presenter;

import com.dream.bilibili.base.presenter.BasePresenter;
import com.dream.bilibili.contract.LoginContract;
import com.dream.bilibili.model.DataManager;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/7/6.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {


    @Inject
    LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }



}
