package command;

import jrtb.command.Command;
import jrtb.command.StartCommand;

import static jrtb.command.StartCommand.START_TEXT;
import static jrtb.command.Commands.START;

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
        return new StartCommand(sendMessageBotService, telegramUserService);
    }
}
