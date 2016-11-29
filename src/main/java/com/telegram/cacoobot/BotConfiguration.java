package com.telegram.cacoobot;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotConfiguration {
    private String botUsername;
    private String botToken;
    private String consumerKey;
    private String consumerSecret;
    private String redirectUrl;

    private static final String CONFIG_FILE = "cacoobot.properties";
    public static Logger log = LoggerFactory.getLogger(BotConfiguration.class);
    public static final BotConfiguration INSTANCE = new BotConfiguration();

    private BotConfiguration() {
        PropertiesConfiguration configuration = null;
        try {
            configuration = new PropertiesConfiguration(CONFIG_FILE);
        } catch (ConfigurationException e) {
            log.error("Error occurred while trying to load configuration file", e);
        }
        this.botUsername = configuration.getString("cacoobot.username");
        this.botToken = configuration.getString("cacoobot.token");
        this.consumerKey = configuration.getString("cacoobot.consumer.key");
        this.consumerSecret = configuration.getString("cacoobot.consumer.secret");
        this.redirectUrl = configuration.getString("cacoobot.redirect.url");
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
}
