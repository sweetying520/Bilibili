package com.dream.bilibili.model.http;

import com.dream.bilibili.model.data.BannerData;
import com.dream.bilibili.model.data.BaseResponse;
import com.dream.bilibili.model.http.api.Api;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * @author quchao
 * @date 2017/11/27
 */

public class RetrofitHelper implements HttpHelper {

    private Api mApi;

    @Inject
    RetrofitHelper(Api api) {
        mApi = api;
    }


    @Override
    public Observable<BaseResponse<List<BannerData>>> getBanner() {
        return mApi.getBanner();
    }
}
