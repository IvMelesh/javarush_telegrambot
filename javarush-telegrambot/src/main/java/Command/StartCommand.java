package Command;

import org.telegram.telegrambots.meta.api.objects.Update;
import service.SendMessageBotService;

public class StartCommand implements Command{
    private final SendMessageBotService sendMessageBotService;
    public static String START_TEXT = "Привет!Я JavaRushBot.Я помогу тебе быть в курсе новых статей"
                                        + "на JavaRush";

    public StartCommand(SendMessageBotService sendMessageBotService){
        this.sendMessageBotService = sendMessageBotService;
    }
    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), START_TEXT);

    }
}
