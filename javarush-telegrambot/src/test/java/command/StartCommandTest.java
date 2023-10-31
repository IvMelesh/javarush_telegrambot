package command;

import static command.StartCommand.START_TEXT;
import static command.Commands.START;

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
