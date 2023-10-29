package Command;

import org.telegram.telegrambots.meta.api.objects.Update;
import service.SendMessageBotService;

public class UnknownCommand implements Command{
    private final SendMessageBotService sendMessageBotService;
    public   static String UNKNOWN_COMMAND_TEXT = "Неизвестная команда, я еще таких не выучил\n"
            + "Введите команду заново или посмотрите доступные команды(/help)";

    public UnknownCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_COMMAND_TEXT);
    }
}
