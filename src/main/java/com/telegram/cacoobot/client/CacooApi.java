package com.telegram.cacoobot.client;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;

/**
 * @author Ekaterina Fomenko
 * @brief This is an Api for Cacoo site
 * @date 6 of December of 2016
 */

public class CacooApi extends DefaultApi10a {
    public static final String CACOO_URL = "https://cacoo.com/";
    private static final String AUTHORIZE_URL = CACOO_URL + "oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = CACOO_URL + "oauth/request_token";
    private static final String ACCESS_TOKEN_URL = CACOO_URL + "oauth/access_token";
    public static final CacooApi INSTANCE = new CacooApi();

    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_URL;
    }

    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return String.format(AUTHORIZE_URL, requestToken.getToken());
    }
}
