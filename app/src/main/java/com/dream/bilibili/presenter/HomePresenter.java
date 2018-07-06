package com.dream.bilibili.presenter;

import com.dream.bilibili.base.presenter.BasePresenter;
import com.dream.bilibili.contract.HomeContract;
import com.dream.bilibili.model.DataManager;

import javax.inject.Inject;

/**
 *
 * @author Administrator
 * @date 2018/7/6
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    @Inject
    HomePresenter(DataManager dataManager) {
        super(dataManager);
    }
}
