package com.github.exadmin.hcstbot.telegram.reply;

import com.pengrad.telegrambot.model.Update;

import java.util.Map;

public class HelpUserMessageProcessor extends AbstractMessageProcessor {
    @Override
    public String getMessageKeyword() {
        return "/help";
    }

    @Override
    public String getMsgProcessorDescription() {
        return "provides list of supported commands";
    }

    @Override
    public String prepareTextResponse(Update update, String userMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append("Following commands are supported:\n");

        for (Map.Entry<String, AbstractMessageProcessor> me : MessageProcessorsFactory.getMsgProcessorsMap().entrySet()) {
            String key = me.getKey();
            AbstractMessageProcessor msgProcessor = me.getValue();
            sb.append(key + " - " + msgProcessor.getMsgProcessorDescription() + "\n");
        }

        return sb.toString();
    }
}
