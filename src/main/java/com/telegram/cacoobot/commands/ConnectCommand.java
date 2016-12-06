package com.telegram.cacoobot.commands;

import com.telegram.cacoobot.client.CacooClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;

import java.io.IOException;

/**
 * @author Ekaterina Fomenko
 * @brief This class describe connect command functionality.
 * Through this command user can connect to her profile in cacoo site
 * @date 6 of December of 2016
 */

public class ConnectCommand extends BotCommand {

    public static Logger log = LoggerFactory.getLogger(ConnectCommand.class);

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
            log.error("Error occurred while trying to get authorization url");
        }

        new MessageSender().sendMessageToUser(absSender, chatId, messageTextBuilder);
    }
}
