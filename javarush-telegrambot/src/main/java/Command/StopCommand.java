package Command;

import org.telegram.telegrambots.meta.api.objects.Update;
import service.SendMessageBotService;

public class StopCommand implements Command{
    private final SendMessageBotService sendMessageBotService;

    public static String STOP_TEXT = "Деактивировал все ваши подписки";

    public StopCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), STOP_TEXT);

    }


}
