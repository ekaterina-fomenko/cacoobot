package com.telegram.cacoobot.commands;

import com.telegram.cacoobot.client.CacooClient;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;

import java.io.IOException;

public class ConnectCommand extends BotCommand {

    public ConnectCommand() {
        super("connect", "Connect to your Cacoo profile");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        String chatId = chat.getId().toString();
        CacooClient client = new CacooClient(chatId);
        StringBuilder messageTextBuilder = null;
        try {
            messageTextBuilder = new StringBuilder("Authorize please: ").append(client.getAuthorizationUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new MessageSender().sendMessageToUser(absSender, chatId, messageTextBuilder);
    }
}
