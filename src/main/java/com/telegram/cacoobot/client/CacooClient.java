package com.telegram.cacoobot.client;


import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.telegram.cacoobot.BotConfiguration;

import java.io.IOException;

/**
 * @author Ekaterina Fomenko
 * @brief This class helps to build cacoo client
 * @date 6 of December of 2016
 */

public class CacooClient {
    private final OAuth10aService service;
    private OAuth1RequestToken requestToken;

    public CacooClient(String chatId) {
        service = new ServiceBuilder()
                .apiKey(BotConfiguration.INSTANCE.getConsumerKey())
                .apiSecret(BotConfiguration.INSTANCE.getConsumerSecret())
                .callback(BotConfiguration.INSTANCE.getRedirectUrl() + "/redirect?chatId=" + chatId)
                .build(CacooApi.INSTANCE);
    }

    public String getAuthorizationUrl() throws IOException {
        requestToken = service.getRequestToken();
        return service.getAuthorizationUrl(requestToken);
    }
}
