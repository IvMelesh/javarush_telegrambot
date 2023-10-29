package command;

import static Command.StartCommand.START_TEXT;
import static Command.Commands.START;
import Command.*;

public class StartCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getText() {
        return START_TEXT;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendMessageBotService);
    }
}
