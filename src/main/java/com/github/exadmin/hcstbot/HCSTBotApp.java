package com.github.exadmin.hcstbot;

import com.github.exadmin.hcstbot.services.ServicesCrawler;
import com.github.exadmin.hcstbot.telegram.TelegramBotService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HCSTBotApp {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("./data/do-not-commit-to-git.properties")));
        String tgToken = properties.getProperty("tg-token");
        TelegramBotService telegramBotService = new TelegramBotService();
        telegramBotService.runService(tgToken);

        ServicesCrawler crawler = new ServicesCrawler();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleWithFixedDelay(crawler, 5, 10, TimeUnit.SECONDS);
    }
}
