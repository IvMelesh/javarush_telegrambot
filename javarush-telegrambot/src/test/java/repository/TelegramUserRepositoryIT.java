package repository;

import jrtb.repository.TelegramUserRepository;
import jrtb.repository.entity.TelegramUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class TelegramUserRepositoryIT {
    @Autowired
    TelegramUserRepository telegramUserRepository;

    @Sql(scripts = {"/resources/cleatDb.sql", "/resources/telegram_users.sql"})
    @Test
    public void shouldProperlyFindAllActiveUsers() {
        //when
        List<TelegramUser> users = telegramUserRepository.findAllByActiveTrue();

        //then
        Assertions.assertEquals(5, users.size());
    }
    @Sql(scripts={"/resources/clearDb.sql"})
    @Test
    public void shouldProperlySaveUser(){
        //given
    TelegramUser user = new TelegramUser();
    user.setChatId("111111");
    user.setActive(false);
    telegramUserRepository.save(user);
       //when
        Optional<TelegramUser> saved = telegramUserRepository.findById(user.getChatId());

       //then
        Assertions.assertTrue(saved.isPresent());
        Assertions.assertEquals(user, saved.get());
    }


}
