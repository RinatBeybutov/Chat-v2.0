package com.maxima.chat.repository;

import com.maxima.chat.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с таблицей сообщений
 */
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

}
