package com.netease.study.okhttpclient.config;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ushu")
@Data
public class UshuConfig {
    private String apiBase;

    private String portal;

    private String appId;

    private String appKey;

    private String appSecret;
}
