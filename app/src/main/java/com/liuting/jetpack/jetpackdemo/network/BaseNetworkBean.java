package com.liuting.jetpack.jetpackdemo.network;

/**
 * 作者:admin on 2020/10/18 15:06
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.network
 * TODO:
 */
public class BaseNetworkBean<T> {
    public int error_code;
    public String reason;
    public T	result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }





}
