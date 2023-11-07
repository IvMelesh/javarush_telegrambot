package jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import jrtb.service.SendMessageBotService;

public class HelpCommand implements Command{
    private final SendMessageBotService sendMessageBotService;
    public static String HELP_TEXT = String.format("<b>Доступные команды для работы</b>\n"
    +"%s - начало работы\n"
    +"%s - окончание работы\n"
    +"%s - справочник команд\n"
                    +"%s - статистика",
            Commands.START.getCommandName(), Commands.STOP.getCommandName(), Commands.HELP.getCommandName(), Commands.STAT.getCommandName());

    public HelpCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), HELP_TEXT);

    }
}
