package com.netease.study.okhttpclient.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.netease.study.okhttpclient.config.UshuConfig;
import com.netease.study.okhttpclient.models.GetAccessTokenResult;
import com.netease.study.okhttpclient.models.SendMessageRequest;
import com.netease.study.okhttpclient.models.SendMessageResponse;
import com.netease.study.okhttpclient.models.UshuResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UshuClient {

    private static final String ACCESS_TOKEN_GET = "/token/get?app_key=%s&app_secret=%s";
    private static final String MESSAGE_SEND = "/message/send_lang?access_token=%s";

    private static final int ERROR_CODE_ACCESS_TOKEN_EXPIRED = 40005;

    private static String accessToken;
    /**
     * 单位秒
     */
    private static long expiresIn;

    @Autowired
    private UshuConfig ushuConfig;

    public String getAccessToken(boolean force){
        if(!force && StringUtils.isNotEmpty(accessToken) && expiresIn > timestamp()){
            return accessToken;
        }
        Request request = new Request.Builder()
                .url(String.format(ushuConfig.getApiBase() + ACCESS_TOKEN_GET,ushuConfig.getAppKey(),ushuConfig.getAppSecret()))
                .get()
                .build();
        UshuResponse<GetAccessTokenResult> r = request(request, new TypeReference<UshuResponse<GetAccessTokenResult>>() {
        });

        if(r.ok()){
            final GetAccessTokenResult result = r.getResult();
            log.info("accessToken刷新成功 {}",JSON.toJSONString(result));
            accessToken = result.getAccessToken();
            expiresIn = timestamp() + result.getExpiresIn();
            return accessToken;
        }
        throw new RuntimeException(r.toString());
    }

    public UshuResponse<SendMessageResponse> sendMessage(final SendMessageRequest sendMessageRequest){
        log.info("发送HLINK消息 to {}",String.join(",",sendMessageRequest.getToUser()));
        sendMessageRequest.setMsgType("rtf");
        sendMessageRequest.setAppId(ushuConfig.getAppId());
        sendMessageRequest.setPortal(ushuConfig.getPortal());
        for(;;){
            Request request = new Request.Builder()
                    .url(String.format(ushuConfig.getApiBase() + MESSAGE_SEND,getAccessToken(false)))
                    .post(RequestBody.create(MediaType.get("application/json"),JSON.toJSONString(sendMessageRequest)))
                    .build();
            UshuResponse<SendMessageResponse> response = request(request, new TypeReference<UshuResponse<SendMessageResponse>>() {
            });
            if(response.ok()){
                log.info("发送HLINK消息 result:{}",JSON.toJSONString(response.getResult()));
                return response;
            }

            if(response.getErrorCode() == ERROR_CODE_ACCESS_TOKEN_EXPIRED){
                getAccessToken(true);
                continue;
            }
            throw new RuntimeException(response.toString());
        }
    }

    private <R,T extends UshuResponse<R>> T request(Request request, TypeReference<T> typeReference){
        final OkHttpClient httpClient = new OkHttpClient.Builder().build();
        try(Response response = httpClient.newCall(request).execute()){
            final ResponseBody body = response.body();
            assert body != null;
            return JSON.parseObject(body.string(),typeReference);
        }catch (Exception ex){
            log.warn("request",ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * 毫秒转化为秒
     * @return
     */
    private long timestamp(){
        return System.currentTimeMillis() / 1000;
    }
}
