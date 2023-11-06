package command;

import jrtb.command.Command;
import jrtb.command.CommandContainer;
import jrtb.command.Commands;
import jrtb.command.UnknownCommand;
import jrtb.service.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import jrtb.service.SendMessageBotService;

import java.util.Arrays;

@DisplayName("Unit-lvl testing for CommandContainer")
public class CommandContainerTest {
    private CommandContainer commandContainer;
    private TelegramUserService telegramUserService;

    @BeforeEach
    public void init(){
        SendMessageBotService sendMessageBotService = Mockito.mock(SendMessageBotService.class);
        TelegramUserService telegramUserService1 = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendMessageBotService, telegramUserService1);
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
