package com.dream.bilibili.model.http;


import com.dream.bilibili.model.data.BannerData;
import com.dream.bilibili.model.data.BaseResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author quchao
 * @date 2017/11/27
 */

public interface HttpHelper {

    Observable<BaseResponse<List<BannerData>>> getBanner();
}
