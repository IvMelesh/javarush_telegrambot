package command;

import static command.UnknownCommand.UNKNOWN_COMMAND_TEXT;

public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/dsfsdfdsfdf";
    }

    @Override
    String getText() {
        return UNKNOWN_COMMAND_TEXT;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendMessageBotService);
    }
}
