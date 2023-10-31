package command;

import static command.Commands.HELP;
import static command.HelpCommand.HELP_TEXT;

public class HelpCommandTest  extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getText() {
        return HELP_TEXT;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendMessageBotService);
    }
}
