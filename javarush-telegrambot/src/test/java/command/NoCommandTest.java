package command;

import static command.Commands.NO;
import static command.NoCommand.NO_COMMAND_TEXT;


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
