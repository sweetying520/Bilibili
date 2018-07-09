package com.dream.bilibili.presenter;

import android.util.Log;

import com.dream.bilibili.R;
import com.dream.bilibili.base.presenter.BasePresenter;
import com.dream.bilibili.contract.HomeContract;
import com.dream.bilibili.model.DataManager;
import com.dream.bilibili.model.data.BannerData;
import com.dream.bilibili.model.data.live.LiveRecommend;
import com.dream.bilibili.util.CommonUtils;
import com.dream.bilibili.util.RxUtils;
import com.dream.bilibili.widget.BaseObserver;

import java.util.List;

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

    @Override
    public void attachView(HomeContract.View view) {
        super.attachView(view);
    }

    @Override
    public void getLiveRecommond() {
        addSubscribe(mDataManager.getBanner()
        .compose(RxUtils.rxSchedulerHelper())
        .compose(RxUtils.handleResult())
        .subscribeWith(new BaseObserver<List<BannerData>>(mView, CommonUtils.getString(R.string.failed_to_get_live_recommned_data)){

            @Override
            public void onNext(List<BannerData> bannerData) {
                Log.d("print", "-->"  + bannerData.size());
            }
        }));
    }

    @Override
    public void getBannerData() {
        addSubscribe(mDataManager.getLiveRecommend()
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<LiveRecommend>(mView,CommonUtils.getString(R.string.failed_to_get_banner_data)){

                    @Override
                    public void onNext(LiveRecommend liveRecommend) {
                        Log.d("print", "--->" + liveRecommend.recommend_data.partition.name);
                    }
                }));
    }
}
