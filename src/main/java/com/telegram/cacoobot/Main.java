package com.telegram.cacoobot;

import com.telegram.cacoobot.commands.CommandsHandler;
import com.telegram.cacoobot.spring.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

public class Main {
    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        SpringBootApplication.runSpringBoot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(CommandsHandler.INSTANCE);
        } catch (TelegramApiException e) {
            log.error("Exception was occurred while trying to register bot", e);
        }

    }
}
