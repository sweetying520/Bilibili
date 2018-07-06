package com.dream.bilibili.contract;

import com.dream.bilibili.base.presenter.AbstractPresenter;
import com.dream.bilibili.base.view.BaseView;

/**
 * Created by Administrator on 2018/6/9.
 */

public interface TestContract {

    interface View extends BaseView{
        void testPresenter();

        void showSuccess();
    }

    interface Presneter extends AbstractPresenter<View>{
        void testView();

        void testGetData();
    }
}
