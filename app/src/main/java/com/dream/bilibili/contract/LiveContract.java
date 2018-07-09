package com.dream.bilibili.contract;

import com.dream.bilibili.base.presenter.AbstractPresenter;
import com.dream.bilibili.base.view.BaseView;
import com.dream.bilibili.model.data.live.LivePartition;
import com.dream.bilibili.model.data.live.LiveRecommend;

/**
 * Created by Administrator on 2018/7/6.
 */

public interface LiveContract {

    interface View extends BaseView{
        void hideSwipeRefreshlayout();

        void showLivePartitionData(LivePartition mLivePartition);

        void showLiveRecommendData(LiveRecommend mLiveRecommend);
    }

    interface Presenter extends AbstractPresenter<View>{
        void getLiveData();
    }
}
