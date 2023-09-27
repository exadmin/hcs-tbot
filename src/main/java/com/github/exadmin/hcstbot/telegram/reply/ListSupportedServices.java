package com.github.exadmin.hcstbot.telegram.reply;

import com.github.exadmin.hcstbot.services.HCServicesFactory;
import com.pengrad.telegrambot.model.Update;

public class ListSupportedServices extends AbstractMessageProcessor {
    @Override
    public String getMessageKeyword() {
        return "/list_all_services";
    }

    @Override
    public String getMsgProcessorDescription() {
        return "Provides list of all supported housing and communal services";
    }

    @Override
    public String prepareTextResponse(Update update, String userMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append("Following services are supported currently:\n");
        for (String serviceId : HCServicesFactory.getServicesMap().keySet()) {
            sb.append(serviceId + "\n");
        }

        return sb.toString();
    }
}
