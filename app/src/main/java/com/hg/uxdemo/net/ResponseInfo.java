package com.hg.uxdemo.net;

import com.hg.zero.net.callback.contract.ZResponseInfo;

/**
 * 请求回调
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
public class ResponseInfo implements ZResponseInfo {

    private int code;
    private Object data;
    private String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public <T> T getTag() {
        return null;
    }
}
