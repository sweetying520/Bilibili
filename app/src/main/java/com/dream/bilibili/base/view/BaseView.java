package com.dream.bilibili.base.view;


/**
 *  View 基类
 *
 * @author quchao
 * @date 2017/11/27
 */

public interface BaseView {


    /**
     * Show error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    /**
     * showNormal
     */
    void showNormal();

    /**
     * Show error
     */
    void showError();

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Reload
     */
    void reload();

}
