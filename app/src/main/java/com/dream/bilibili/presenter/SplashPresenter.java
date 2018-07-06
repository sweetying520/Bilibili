package com.dream.bilibili.presenter;

import com.dream.bilibili.base.presenter.BasePresenter;
import com.dream.bilibili.contract.SplashContract;
import com.dream.bilibili.model.DataManager;
import com.dream.bilibili.util.RxUtils;
import com.dream.bilibili.widget.BaseObserver;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Administrator
 * @date 2018/7/6
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    @Inject
    SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void splash() {
        long countDown = 5;
        addSubscribe(Observable.interval(0, 1, TimeUnit.SECONDS)
                .compose(RxUtils.rxSchedulerHelper())
                .take(countDown + 1)
                .map(aLong -> countDown - aLong)
                .subscribeWith(new BaseObserver<Long>(mView) {
                    @Override
                    public void onNext(Long aLong) {
                        mView.showCountDown(aLong);
                    }

                    @Override
                    public void onComplete() {
                        mView.toMainActivity();
                    }
                }));
    }
}
