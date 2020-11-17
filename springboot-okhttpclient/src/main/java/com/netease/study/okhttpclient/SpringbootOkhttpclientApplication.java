package com.netease.study.okhttpclient;

import com.alibaba.fastjson.JSONObject;
import com.netease.study.okhttpclient.models.SendMessageRequest;
import com.netease.study.okhttpclient.models.SendMessageResponse;
import com.netease.study.okhttpclient.models.UshuResponse;
import com.netease.study.okhttpclient.utils.UshuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootOkhttpclientApplication {

    @Autowired
    private UshuClient ushuClient;

    @RequestMapping(value = "/message/send",method = RequestMethod.POST)
    public UshuResponse<SendMessageResponse> sendMessage(@RequestBody String request){
        SendMessageRequest r = JSONObject.parseObject(request,SendMessageRequest.class);
        return ushuClient.sendMessage(r);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOkhttpclientApplication.class, args);
    }

}
