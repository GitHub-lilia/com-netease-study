package com.netease.study.okhttpclient.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class SendMessageResponse {

    @JSONField(name = "invaliduser")
    private List<String> invalidUser;
    @JSONField(name = "invaliddept")
    private List<String> invalidDept;
    @JSONField(name = "invalidrole")
    private List<String> invalidRole;
    @JSONField(name = "task_id")
    private int taskId;
    @JSONField(name = "send_immediately")
    private boolean sendImmediately;
}
