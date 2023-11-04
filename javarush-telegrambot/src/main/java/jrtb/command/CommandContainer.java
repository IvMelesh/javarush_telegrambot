package jrtb.command;


import com.google.common.collect.ImmutableMap;
import jrtb.service.SendMessageBotService;
import jrtb.service.TelegramUserService;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final UnknownCommand unknownCommand;

    public CommandContainer(SendMessageBotService sendMessageBotService, TelegramUserService telegramUserService){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(Commands.START.getCommandName(), new StartCommand(sendMessageBotService, telegramUserService))
                .put(Commands.STOP.getCommandName(), new StopCommand(sendMessageBotService, telegramUserService))
                .put(Commands.HELP.getCommandName(), new HelpCommand(sendMessageBotService))
                .put(Commands.NO.getCommandName(), new HelpCommand(sendMessageBotService))
                .put(Commands.STAT.getCommandName(), new StatCommand(sendMessageBotService, telegramUserService))
                .build();

        unknownCommand = new UnknownCommand(sendMessageBotService);

    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier,unknownCommand);

    }
}
