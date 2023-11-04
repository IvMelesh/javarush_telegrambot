package jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import jrtb.repository.entity.TelegramUser;
import jrtb.service.SendMessageBotService;
import jrtb.service.TelegramUserService;

public class StartCommand implements Command{
    private final SendMessageBotService sendMessageBotService;
    private final TelegramUserService telegramUserService;
    public static String START_TEXT = "Привет!Я JavaRushBot.Я помогу тебе быть в курсе новых статей"
                                        + "на JavaRush";

    public StartCommand(SendMessageBotService sendMessageBotService, TelegramUserService telegramUserService){
        this.sendMessageBotService = sendMessageBotService;
        this.telegramUserService = telegramUserService;
    }
    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                }
        );
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), START_TEXT);

    }
}
