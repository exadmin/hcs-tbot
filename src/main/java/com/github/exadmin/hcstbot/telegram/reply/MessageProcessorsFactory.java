package com.github.exadmin.hcstbot.telegram.reply;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MessageProcessorsFactory {
    // ***** REGISTER ALL SUPPORTED COMMANDS HERE *****
    private static final Map<String, AbstractMessageProcessor> initMap = new HashMap<>();
    static {
        registerMessageProcessor(new HelpUserMessageProcessor());
        registerMessageProcessor(new ListSupportedServices());
    }

    private static void registerMessageProcessor(AbstractMessageProcessor cmd) {
        String key = cmd.getMessageKeyword();
        initMap.put(key, cmd);
    }

    // ***** PREPARE UNMODIFIABLE MAP OF COMMANDS *****
    private static final Map<String, AbstractMessageProcessor> MSG_PROCESSORS_MAP = Collections.unmodifiableMap(initMap);
    public static Map<String, AbstractMessageProcessor> getMsgProcessorsMap() {
        return MSG_PROCESSORS_MAP;
    }

    public static AbstractMessageProcessor DEFAULT_MESSAGE_PROCESSOR = new DefaultMessageProcessor();
}
