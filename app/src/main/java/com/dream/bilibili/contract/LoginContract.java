package com.dream.bilibili.contract;

import com.dream.bilibili.base.presenter.AbstractPresenter;
import com.dream.bilibili.base.view.BaseView;

/**
 * Created by Administrator on 2018/7/6.
 */

public interface LoginContract {


    interface View extends BaseView{

    }

    interface Presenter extends AbstractPresenter<View>{

    }
}
