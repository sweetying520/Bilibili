package com.dream.bilibili.model.http.api;


import com.dream.bilibili.model.data.BannerData;
import com.dream.bilibili.model.data.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author quchao
 * @date 2018/2/12
 */

public interface Api {


    String BASR_URL = "http://test.bigbuy.win/";


    @GET("appapi/index/banner/id/1?cmd=home_slider_top&limit=5")
    Observable<BaseResponse<List<BannerData>>> getBanner();

}
