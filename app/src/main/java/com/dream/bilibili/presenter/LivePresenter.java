package com.dream.bilibili.presenter;

import com.dream.bilibili.base.presenter.BasePresenter;
import com.dream.bilibili.contract.LiveContract;
import com.dream.bilibili.model.DataManager;
import com.dream.bilibili.model.data.live.LiveRecommend;
import com.dream.bilibili.util.RxUtils;
import com.dream.bilibili.widget.BaseObserver;

import javax.inject.Inject;

/**
 * @author Administrator
 * @date 2018/7/6
 */

public class LivePresenter extends BasePresenter<LiveContract.View> implements LiveContract.Presenter {

    @Inject
    LivePresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void getLiveData() {
        addSubscribe(mDataManager.getLivePartition()
                .compose(RxUtils.handleResult())
                .flatMap(livePartition -> {
                    mView.showLivePartitionData(livePartition);
                    return mDataManager.getLiveRecommend();
                })
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<LiveRecommend>(mView) {

                    @Override
                    public void onNext(LiveRecommend liveRecommend) {
                        mView.hideSwipeRefreshlayout();
                        mView.showLiveRecommendData(liveRecommend);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.hideSwipeRefreshlayout();
                    }
                })
        );
    }
}
