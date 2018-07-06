package com.dream.bilibili.widget;

import android.text.TextUtils;

import com.dream.bilibili.R;
import com.dream.bilibili.base.view.BaseView;
import com.dream.bilibili.model.http.exception.ServerException;
import com.dream.bilibili.util.CommonUtils;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * @author quchao
 * @date 2018/4/2
 */

public abstract class BaseSubscribe <T> extends ResourceSubscriber<T> {

    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowError = true;

    protected BaseSubscribe(BaseView view){
        this.mView = view;
    }

    protected BaseSubscribe(BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseSubscribe(BaseView view, boolean isShowError){
        this.mView = view;
        this.isShowError = isShowError;
    }

    protected BaseSubscribe(BaseView view, String errorMsg, boolean isShowError){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ServerException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg(CommonUtils.getString(R.string.http_error));
        } else {
            mView.showErrorMsg(CommonUtils.getString(R.string.unKnown_error));
        }
        if (isShowError) {
            mView.showError();
        }
    }
}
