package bot;

import command.CommandContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import service.SendMessageBotServiceImp;

import static command.Commands.NO;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {
    private static String COMMAND_PREF = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public JavaRushTelegramBot(){

        this.commandContainer = new CommandContainer(new SendMessageBotServiceImp(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()&&update.getMessage().hasText()){
            String massage = update.getMessage().getText().trim();
            if(massage.startsWith(COMMAND_PREF)){
                String commandIdentifier = massage.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            }
            else commandContainer.retrieveCommand(NO.getCommandName()).execute(update);

        }

    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
