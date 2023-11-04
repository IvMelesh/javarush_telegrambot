package command;

import jrtb.bot.JavaRushTelegramBot;
import jrtb.command.Command;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import jrtb.service.SendMessageBotService;
import jrtb.service.SendMessageBotServiceImp;

public abstract class AbstractCommandTest {
    protected JavaRushTelegramBot javaRushTelegramBot = Mockito.mock(JavaRushTelegramBot.class);
    protected SendMessageBotService sendMessageBotService = new SendMessageBotServiceImp(javaRushTelegramBot);

    abstract String getCommandName();

    abstract String getText();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatID  = 123212132L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatID);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(getText());
        sendMessage.setChatId(chatID.toString());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);
        //then
        Mockito.verify(javaRushTelegramBot).execute(sendMessage);
    }

}
