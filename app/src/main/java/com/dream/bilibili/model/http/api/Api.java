package com.dream.bilibili.model.http.api;


import com.dream.bilibili.common.MyConstants;
import com.dream.bilibili.model.data.BannerData;
import com.dream.bilibili.model.data.BaseResponse;
import com.dream.bilibili.model.data.live.LiveEntrance;
import com.dream.bilibili.model.data.live.LivePartition;
import com.dream.bilibili.model.data.live.LiveRecommend;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * @author quchao
 * @date 2018/2/12
 */

public interface Api {


    String LIVE_BASE_URL = "http://api.live.bilibili.com";

    String APP_BASE_URL = "http://app.bilibili.com/";

    String RANK_BASE_URL = "http://www.bilibili.com/";

    String API_BASE_URL = "http://api.bilibili.cn/";

    String BANGUMI_BASE_URL = "https://bangumi.bilibili.com/";

    String IM9_BASE_URL = "http://www.im9.com/";

    String COMMON_UA_STR = "BiliSoleil Android Client/1.0 (soleilyoyiyi@gmail.com)";

    String BASR_URL = "http://www.aiichic.com/";

    String URL_NAME = "urlname:";



    @Headers({URL_NAME + MyConstants.KEY_AII})
    @GET("appapi/index/banner/id/1?cmd=home_slider_top&limit=5")
    Observable<BaseResponse<List<BannerData>>> getBanner();


    //------------------------------------------------------live-------------------------------------------------------------------------------------
    /**
     * 首页推荐直播
     *
     * @return  Observable<BaseResponse<LiveRecommend>>
     */
    @Headers({URL_NAME + MyConstants.KEY_LIVE})
    @GET("/AppNewIndex/recommend?_device=android&access_key=5b0032c681c2233870c8edcee410b6c6&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&scale=xxhdpi&ts=1495639021&sign=9d024a5b09edddd51636d17d860622d2")
    Observable<BaseResponse<LiveRecommend>> getLiveRecommend();

    /**
     * 直播分区
     *
     * @return Observable<BaseResponse<LivePartition>>
     */
    @Headers({URL_NAME + MyConstants.KEY_LIVE})
    @GET("/AppNewIndex/common?_device=android&access_key=5b0032c681c2233870c8edcee410b6c6&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&scale=xxhdpi&ts=1495639884&sign=74b510ce56ef302742aafad2e20f9899")
    Observable<BaseResponse<LivePartition>> getLivePartition();

    /**
     * 获取直播分区的tag标题
     *
     * @return Observable<BaseResponse<List<LiveEntrance>>>
     */
    @GET("/AppIndex/areas?_device=android&access_key=21073183486ba556121c1160f107f0c5&appkey=1d8b6e7d45233436&build=506000&mobi_app=android&platform=android&scale=xxhdpi&ts=1496116760&sign=e2231dc84bc33bc1a7c6d8eddf13da9d")
    Observable<BaseResponse<List<LiveEntrance>>> getLiveEntrance();
    //------------------------------------------------------live-------------------------------------------------------------------------------------




}
