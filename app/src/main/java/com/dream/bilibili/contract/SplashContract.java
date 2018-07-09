package com.dream.bilibili.contract;

import com.dream.bilibili.base.presenter.AbstractPresenter;
import com.dream.bilibili.base.view.BaseView;

/**
 * Created by Administrator on 2018/7/6.
 */

public interface SplashContract {

    interface View extends BaseView{
        void showCountDown(long countDownTime);

        void toLoginActivity();
    }

    interface Presenter extends AbstractPresenter<View> {
        void splash();
    }
}
