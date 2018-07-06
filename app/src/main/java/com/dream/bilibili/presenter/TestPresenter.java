package com.dream.bilibili.presenter;

import android.util.Log;

import com.dream.bilibili.base.presenter.BasePresenter;
import com.dream.bilibili.contract.TestContract;
import com.dream.bilibili.model.DataManager;
import com.dream.bilibili.model.data.BannerData;
import com.dream.bilibili.util.RxUtils;
import com.dream.bilibili.widget.BaseObserver;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Administrator
 * @date 2018/6/9
 */

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presneter {

    @Inject
    TestPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void attachView(TestContract.View view) {
        super.attachView(view);
        mView.testPresenter();
    }

    @Override
    public void testView() {
        Log.d("print", "Presenter层的引用");
    }

    @Override
    public void testGetData() {
        addSubscribe(mDataManager.getBanner()
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<List<BannerData>>(mView,"错误信息提示") {
                    @Override
                    public void onNext(List<BannerData> bannerData) {
                        mView.showSuccess();
                    }
                }));

//        addSubscribe(mDataManager.getBanner()
//        .compose(RxUtils.rxSchedulerHelper())
//        .compose(RxUtils.handleResult())
//        .subscribeWith(new BaseObserver<List<BannerData>>(mView){
//
//            @Override
//            public void onNext(List<BannerData> bannerData) {
//
//            }
//        }));
    }


}
