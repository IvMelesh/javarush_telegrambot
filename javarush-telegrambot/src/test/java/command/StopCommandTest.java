package command;

import static command.Commands.STOP;
import static command.StopCommand.STOP_TEXT;

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
