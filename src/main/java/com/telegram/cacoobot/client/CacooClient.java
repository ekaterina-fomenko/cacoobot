package com.telegram.cacoobot.client;


import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.telegram.cacoobot.BotConfiguration;

import java.io.IOException;

public class CacooClient {
    //private static final String CONSUMER_KEY = "aKsbGWFvUtjfqnzzSmltNf";
    //private static final String CONSUMER_SECRET = "bkKkvhKCymHhWvwniYNfscbpyAaLBrpqIBbfMBJSkX";
    private final OAuth10aService service;
    private OAuth1RequestToken requestToken;

    public CacooClient(String chatId) {
        service = new ServiceBuilder()
                .apiKey(BotConfiguration.INSTANCE.getConsumerKey())
                .apiSecret(BotConfiguration.INSTANCE.getConsumerSecret())
                        //.callback("http://172.20.10.9:8080/redirect?chatId=" + chatId)
                .callback(BotConfiguration.INSTANCE.getRedirectUrl() + "/redirect?chatId=" + chatId)
                .build(CacooApi.INSTANCE);
    }

    public String getAuthorizationUrl() throws IOException {
        requestToken = service.getRequestToken();
        return service.getAuthorizationUrl(requestToken);
    }


/*
    public OAuth1AccessToken getAccessToken() throws IOException {
        OAuth1AccessToken accessToken = service.getAccessToken(requestToken, verifierCode);
        return accessToken;
    }
*/
}
