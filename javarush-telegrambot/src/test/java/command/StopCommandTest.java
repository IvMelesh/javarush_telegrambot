package command;

import Command.*;
import static Command.Commands.STOP;
import static Command.StopCommand.STOP_TEXT;

public class StopCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getText() {
        return STOP_TEXT;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendMessageBotService);
    }
}
