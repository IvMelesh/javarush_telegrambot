package jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import jrtb.service.SendMessageBotService;
import jrtb.service.TelegramUserService;

public class StopCommand implements Command{
    private final SendMessageBotService sendMessageBotService;
    private final TelegramUserService telegramUserService;

    public static String STOP_TEXT = "Деактивировал все ваши подписки";

    public StopCommand(SendMessageBotService sendMessageBotService, TelegramUserService telegramUserService) {
        this.sendMessageBotService = sendMessageBotService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {

        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), STOP_TEXT);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(user ->{
                    user.setActive(false);
                    telegramUserService.save(user);
                });
    }


}
