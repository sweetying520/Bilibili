package com.dream.bilibili.model.http;


import com.dream.bilibili.model.data.BannerData;
import com.dream.bilibili.model.data.BaseResponse;
import com.dream.bilibili.model.data.live.LivePartition;
import com.dream.bilibili.model.data.live.LiveRecommend;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author quchao
 * @date 2017/11/27
 */

public interface HttpHelper {

    Observable<BaseResponse<List<BannerData>>> getBanner();

    Observable<BaseResponse<LiveRecommend>> getLiveRecommend();
    Observable<BaseResponse<LivePartition>> getLivePartition();
}
