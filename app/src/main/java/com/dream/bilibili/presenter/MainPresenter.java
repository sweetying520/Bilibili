package com.dream.bilibili.presenter;

import com.dream.bilibili.base.presenter.BasePresenter;
import com.dream.bilibili.contract.MainContract;
import com.dream.bilibili.model.DataManager;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/7/6.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {


    @Inject
    MainPresenter(DataManager dataManager) {
        super(dataManager);
    }



}
