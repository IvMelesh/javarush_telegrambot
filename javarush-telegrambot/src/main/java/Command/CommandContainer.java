package Command;


import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import service.SendMessageBotService;

import static Command.Commands.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final UnknownCommand unknownCommand;

    public CommandContainer(SendMessageBotService sendMessageBotService){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageBotService))
                .put(STOP.getCommandName(), new StopCommand(sendMessageBotService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageBotService))
                .put(NO.getCommandName(), new HelpCommand(sendMessageBotService))
                .build();

        unknownCommand = new UnknownCommand(sendMessageBotService);

    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier,unknownCommand);

    }
}
