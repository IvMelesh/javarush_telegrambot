package jrtb.service;

import jrtb.bot.JavaRushTelegramBot;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageBotServiceImp implements SendMessageBotService {
    private final JavaRushTelegramBot javaRushTelegramBot;
    @Autowired
    public SendMessageBotServiceImp(JavaRushTelegramBot javaRushTelegramBot) {
        this.javaRushTelegramBot = javaRushTelegramBot;
    }

    @Override
    public void sendMessage(String chatID, String message) {
        SendMessage sm = new SendMessage();
        sm.setChatId(chatID);
        sm.enableHtml(true);
        sm.setText(message);

        try {
            javaRushTelegramBot.execute(sm);
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }

    }
}
