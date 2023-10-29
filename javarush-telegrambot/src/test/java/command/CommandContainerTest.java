package command;

import Command.*;
import Command.CommandContainer;
import Command.Commands;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.SendMessageBotService;
import service.SendMessageBotServiceImp;

import java.util.Arrays;

@DisplayName("Unit-lvl testing for CommandContainer")
public class CommandContainerTest {
    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        SendMessageBotService sendMessageBotService = Mockito.mock(SendMessageBotService.class);
        commandContainer = new CommandContainer(sendMessageBotService);
    }
@Test
    public void shouldGetAllTheExistingCommands(){
        //when - then
        Arrays.stream(Commands.values())
                .forEach(Commands-> {
                     Command command = commandContainer.retrieveCommand(Commands.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class,command.getClass() );
                });
    }
@Test
    public void shouldReturnUnknownCommand(){
        String unknownCommand = "/sdadasd";
        Command command = commandContainer.retrieveCommand(unknownCommand);
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
