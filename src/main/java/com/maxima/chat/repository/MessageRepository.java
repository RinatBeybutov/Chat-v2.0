package com.maxima.chat.repository;

import com.maxima.chat.entity.MessageEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Репозиторий для работы с таблицей сообщений
 */
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

  @Query("SELECT m FROM MessageEntity m JOIN FETCH m.user u JOIN FETCH u.city")
  List<MessageEntity> findAllCustom();
}
