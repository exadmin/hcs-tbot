package com.github.exadmin.hcstbot.telegram.reply;

import com.pengrad.telegrambot.model.Update;

public abstract class AbstractMessageProcessor {
    public abstract String getMessageKeyword();
    public abstract String getMsgProcessorDescription();
    public abstract String prepareTextResponse(Update update, String userMessage);
}
