package com.dream.bilibili.model.data;

/**
 * @author quchao
 * @date 2018/2/12
 */

public class BaseResponse<T> {

    public static final int SUCCESS = 0;

    private T data;
    private T result;
    private String message;
    private int code;
    private T rank;
    private T model;

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getRank() {
        return rank;
    }

    public void setRank(T rank) {
        this.rank = rank;
    }

    public T getTargetData(){
        if(data != null){
            return data;
        }else if(result != null){
            return result;
        }else if(model != null){
            return model;
        }else if(rank != null){
            return rank;
        }else {
            return null;
        }
    }
}
