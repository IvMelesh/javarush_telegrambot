package jrtb.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jrtb.repository.TelegramUserRepository;
import jrtb.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;
@Service
public class TelegramUserServiceImp implements TelegramUserService{

    private final TelegramUserRepository telegramUserRepository;
    @Autowired
    public TelegramUserServiceImp(TelegramUserRepository telegramUserRepository) {
        this.telegramUserRepository = telegramUserRepository;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);
    }

    @Override
    public List<TelegramUser> retrieveAllActiveUsers() {
        return telegramUserRepository.findAllByActiveTrue();
    }

    @Override
    public Optional<TelegramUser> findByChatId(String chatId) {
        return telegramUserRepository.findById(chatId);
    }
}
