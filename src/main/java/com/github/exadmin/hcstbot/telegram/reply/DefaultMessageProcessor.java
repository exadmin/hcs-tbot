package com.github.exadmin.hcstbot.telegram.reply;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class DefaultMessageProcessor extends AbstractMessageProcessor {
    @Override
    public String getMessageKeyword() {
        return "/default";
    }

    @Override
    public String getMsgProcessorDescription() {
        return "";
    }

    @Override
    public String prepareTextResponse(Update update, String userMessage) {
        return "Sorry, can't understand your command. Type '/help' to get list of supported commands";
    }
}
