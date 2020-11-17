package com.netease.study.okhttpclient.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UshuResponse<T> {
    @JSONField(name = "error_code")
    private int errorCode;

    private String message;

    private T result;

    public boolean ok() {
        return errorCode == 0;
    }

    @Override
    public String toString() {
        return "[" + errorCode + "]" + message;
    }
}
