package com.netease.study.okhttpclient.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SendMessageRequest {
    @JSONField(name = "msgtype")
    private String msgType;
    @JSONField(name = "touser")
    private List<String> toUser;

    private String portal;
    @JSONField(name = "app_id")
    private String appId;

    private Map<String,Msg> msg;

    @Data
    public static class Msg{

        private String message;

        private String content;

        private String url;

        private String attachmentId;
    }
}
