package Command;

import org.telegram.telegrambots.meta.api.objects.Update;
import service.SendMessageBotService;

import static Command.Commands.*;

public class HelpCommand implements Command{
    private final SendMessageBotService sendMessageBotService;
    private static String HELP_TEXT = String.format("<b>Доступные команды для работы</b>\n"
    +"%s - начало работы\n"
    +"%s - окончание работы\n"
    +"%s - справочник команд",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), HELP_TEXT);

    }
}
