package Command;

public enum Commands {
    START("/start"),
    HELP("/help"),
    NO("nocommmand"),
    STOP("/stop");

    private final String commandName;

    Commands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}
