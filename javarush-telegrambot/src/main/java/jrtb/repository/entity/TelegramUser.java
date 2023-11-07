package jrtb.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity //говорит о том, что это сущность для работы с БД
@Table(name="tg_user") //определяем имя таблицы
public class TelegramUser {

    @Id //Первичный ключ
    @Column(name="chat_id")  //определяем имя поля
    private String chatId;

    @Column(name = "active")
    private boolean active;

}
