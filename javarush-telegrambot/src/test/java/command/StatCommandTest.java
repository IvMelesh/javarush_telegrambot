package command;

import jrtb.command.Command;
import jrtb.command.StartCommand;
import jrtb.command.StatCommand;
import org.junit.jupiter.api.DisplayName;

import static jrtb.command.Commands.STAT;
import static jrtb.command.StatCommand.STAT_TEXT;

public class StatCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getText() {
        return String.format(STAT_TEXT,0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendMessageBotService,telegramUserService);
    }
}
