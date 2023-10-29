package command;

import Command.*;
import static Command.Commands.NO;
import static Command.NoCommand.NO_COMMAND_TEXT;


public class NoCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getText() {
        return NO_COMMAND_TEXT;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendMessageBotService);
    }
}
