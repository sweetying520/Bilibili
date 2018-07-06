package com.dream.bilibili.model.data;

/**
 * @author quchao
 * @date 2018/2/12
 */

public class BaseResponse<T> {

    public static final int SUCCESS = 0;

    /**
     * 0：成功，1：失败
     */
    private int code;

    private String msg;

    private T model;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
