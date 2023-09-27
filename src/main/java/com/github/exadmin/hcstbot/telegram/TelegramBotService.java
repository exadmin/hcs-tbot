package com.github.exadmin.hcstbot.telegram;

import com.github.exadmin.hcstbot.telegram.reply.AbstractMessageProcessor;
import com.github.exadmin.hcstbot.telegram.reply.MessageProcessorsFactory;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class TelegramBotService {
    private TelegramBot bot;

    public void runService(String tgToken) {
        bot = new TelegramBot(tgToken);

        bot.setUpdatesListener(updates -> {
            // ... process updates
            // return id of last processed update or confirm them all
            for (Update update : updates) {
                // Send messages
                String textMessage = update.message().text();

                // select best message processor
                AbstractMessageProcessor msgProcessor = selectMessageProcessor(update, textMessage);
                String responseMsg = msgProcessor.prepareTextResponse(update, textMessage);

                if (responseMsg != null) {
                    long chatId = update.message().chat().id();
                    bot.execute(new SendMessage(chatId, responseMsg));
                }

            }

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
            // Create Exception Handler
        }, e -> {
            if (e.response() != null) {
                // got bad response from telegram
                e.response().errorCode();
                e.response().description();
            } else {
                // probably network error
                e.printStackTrace();
            }
        });
    }

    private AbstractMessageProcessor selectMessageProcessor(Update update, String msgText) {
        if (msgText.startsWith("/")) {
            for (String key : MessageProcessorsFactory.getMsgProcessorsMap().keySet()) {
                if (msgText.equals(key) || msgText.startsWith(key + " ")) return MessageProcessorsFactory.getMsgProcessorsMap().get(key);
            }
        }

        return MessageProcessorsFactory.DEFAULT_MESSAGE_PROCESSOR;
    }
}
