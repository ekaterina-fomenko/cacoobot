package com.telegram.cacoobot.commands;

import com.telegram.cacoobot.BotConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;

public class CommandsHandler extends TelegramLongPollingCommandBot {
    public static Logger log = LoggerFactory.getLogger(CommandsHandler.class);
    public static final CommandsHandler INSTANCE = new CommandsHandler();

    private CommandsHandler() {
        register(new ConnectCommand());
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                String chatId = message.getChatId().toString();
                StringBuilder messageTextBuilder = null;
                if (message.getText().equals("hello")) {
                    messageTextBuilder = new StringBuilder("Hello! Cacoo greet you! Please use bot commands to communicate with bot");

                } else {
                    messageTextBuilder = new StringBuilder("Hey heres your message:\n" + message.getText());
                }
                sendMessageToUser(chatId, messageTextBuilder);
            }
        }
    }

    public void sendMessageToUser(String chatId, StringBuilder messageTextBuilder) {
        SendMessage answer = new SendMessage();
        answer.setChatId(chatId);
        answer.setText(messageTextBuilder.toString());
        try {
            sendMessage(answer);
        } catch (TelegramApiException e) {
            log.error("Error occurred while trying to send message", e);
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfiguration.INSTANCE.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return BotConfiguration.INSTANCE.getBotToken();
    }

}
