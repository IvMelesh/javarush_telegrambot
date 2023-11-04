package command;

import jrtb.command.Command;
import jrtb.command.NoCommand;

import static jrtb.command.Commands.NO;
import static jrtb.command.NoCommand.NO_COMMAND_TEXT;


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
