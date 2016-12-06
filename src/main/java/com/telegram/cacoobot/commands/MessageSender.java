package com.telegram.cacoobot.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.bots.AbsSender;

/**
 * @author Ekaterina Fomenko
 * @brief This is common message sender class for all bot commands
 * @date 6 of December of 2016
 */

public class MessageSender {
    public static Logger log = LoggerFactory.getLogger(CommandsHandler.class);

    public void sendMessageToUser(AbsSender absSender, String chatId, StringBuilder messageTextBuilder) {
        SendMessage answer = new SendMessage();
        answer.setChatId(chatId);
        answer.setText(messageTextBuilder.toString());

        try {
            absSender.sendMessage(answer);
        } catch (TelegramApiException e) {
            log.error("Error occurred while trying to send message", e);
        }
    }

}
