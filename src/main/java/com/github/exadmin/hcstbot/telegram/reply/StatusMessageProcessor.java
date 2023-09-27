package com.github.exadmin.hcstbot.telegram.reply;

import com.pengrad.telegrambot.model.Update;

public class StatusMessageProcessor extends AbstractMessageProcessor {
    @Override
    public String getMessageKeyword() {
        return "/status";
    }

    @Override
    public String getMsgProcessorDescription() {
        return "provides short information about all available services";
    }

    @Override
    public String prepareTextResponse(Update update, String userMessage) {
        return null;
    }
}
