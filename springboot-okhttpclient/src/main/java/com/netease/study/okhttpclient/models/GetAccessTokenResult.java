package com.netease.study.okhttpclient.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class GetAccessTokenResult {
    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "expires_in")
    private long expiresIn;
}
