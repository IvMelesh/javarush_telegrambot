package jrtb.command;

import jrtb.javarushclient.JavaRushGroupClientImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import jrtb.service.SendMessageBotService;
import jrtb.service.TelegramUserService;

public class StatCommand implements Command{

    private final SendMessageBotService sendMessageBotService;
    private final TelegramUserService telegramUserService;

    public  static String STAT_TEXT = "Бот используют %s человек." ;
    @Autowired
    public StatCommand(SendMessageBotService sendMessageBotService, TelegramUserService telegramUserService) {
        this.sendMessageBotService = sendMessageBotService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        int activeUsersCount = telegramUserService.retrieveAllActiveUsers().size();
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(),String.format(STAT_TEXT, activeUsersCount));

    }
}
