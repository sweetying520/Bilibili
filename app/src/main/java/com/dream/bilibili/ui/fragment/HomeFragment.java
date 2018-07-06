package com.dream.bilibili.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dream.bilibili.R;
import com.dream.bilibili.base.fragment.AbstractRootFragment;
import com.dream.bilibili.common.MyConstants;
import com.dream.bilibili.contract.HomeContract;
import com.dream.bilibili.presenter.HomePresenter;

/**
 * Created by Administrator on 2018/7/6.
 */

public class HomeFragment extends AbstractRootFragment<HomePresenter> implements HomeContract.View{



    public static HomeFragment getInstance(String params1,String params2){
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MyConstants.PARAMS_ONE,params1);
        bundle.putString(MyConstants.PARAMS_TWO,params2);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
    }
}
