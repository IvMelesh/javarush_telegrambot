package Command;

import org.telegram.telegrambots.meta.api.objects.Update;
import service.SendMessageBotService;

public class NoCommand implements Command{
    private final SendMessageBotService sendMessageBotService;
    public static String NO_COMMAND_TEXT = "Я умею работать только с командами начинающимися с (/)\n"
                                    +"Попробуйте еще раз.У Вас все получится!!!";

    public NoCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), NO_COMMAND_TEXT);
    }
}
