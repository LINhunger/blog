package com.qg.blog.dto;

/**
 * Created by hunger on 2016/10/19.
 */
//所有ajax请求的返回值类型,封装json结果
public class AjaxResult<T> {
    private  boolean success;
    private T data;
    private  String error;

    public AjaxResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public AjaxResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
