package service;

import jrtb.bot.JavaRushTelegramBot;
import jrtb.service.SendMessageBotService;
import jrtb.service.SendMessageBotServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-lvl testing for SendMessageBotService")
public class SendMessageBotServiceTest {
    private SendMessageBotService sendMessageBotService;
    private  JavaRushTelegramBot javaRushTelegramBot;

    @BeforeEach
    public void init(){
        javaRushTelegramBot = Mockito.mock(JavaRushTelegramBot.class);
        sendMessageBotService = new SendMessageBotServiceImp(javaRushTelegramBot);

    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given(подготавливаем все необходимое для теста)
        String chatID = "chatID";
        String message = "test message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        //when(запускаем метод, который планируем тестировать)
        sendMessageBotService.sendMessage(chatID,message);
        //then(проверяем, правильно ли отработал метод)
        Mockito.verify(javaRushTelegramBot).execute(sendMessage); //Во время вызова метода verify() мы задали правило, что у объекта JRTB должен вызваться метод execute() с параметром sendMessage.
    }
}
