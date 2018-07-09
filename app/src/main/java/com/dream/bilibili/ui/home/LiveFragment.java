package com.dream.bilibili.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dream.bilibili.R;
import com.dream.bilibili.base.fragment.AbstractRootFragment;
import com.dream.bilibili.common.MyConstants;
import com.dream.bilibili.contract.LiveContract;
import com.dream.bilibili.model.data.live.LivePartition;
import com.dream.bilibili.model.data.live.LiveRecommend;
import com.dream.bilibili.presenter.LivePresenter;

import butterknife.BindView;

/**
 *
 * @author Administrator
 * @date 2018/7/9
 */

public class LiveFragment extends AbstractRootFragment<LivePresenter> implements LiveContract.View {


    @BindView(R.id.normal_view)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.live_rv)
    RecyclerView mRecyclerView;

    public static LiveFragment getInstance(String params1, String params2) {
        LiveFragment fragment = new LiveFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MyConstants.PARAMS_ONE, params1);
        bundle.putString(MyConstants.PARAMS_TWO, params2);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initEventAndData() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.post(() -> {
            mSwipeRefreshLayout.setRefreshing(true);
            mPresenter.getLiveData();
        });
    }

    @Override
    public void hideSwipeRefreshlayout() {
        if(mSwipeRefreshLayout != null){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showLivePartitionData(LivePartition mLivePartition) {

    }

    @Override
    public void showLiveRecommendData(LiveRecommend mLiveRecommend) {

    }



}
