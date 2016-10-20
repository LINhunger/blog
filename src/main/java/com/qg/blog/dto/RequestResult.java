package com.qg.blog.dto;

import com.qg.blog.enums.BlogStatEnum;

/**
 * Created by hunger on 2016/10/20.
 */
public class RequestResult<T> {
    private  int state;
    private String stateInfo;
    private T data;

    public RequestResult(BlogStatEnum statEnum, T data) {
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.data = data;
    }

    public RequestResult(BlogStatEnum statEnum) {
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
