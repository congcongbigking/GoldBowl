package com.china.goldbowl.base.mvp;

import java.io.Serializable;

/**
 * Model 基类
 * Created by congcong on 2020/4/7
 */
public class BaseModel<T> implements Serializable {
    private String msg;
    private int code;
    private T data;

    public BaseModel(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
