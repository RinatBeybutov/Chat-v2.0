package com.maxima.chat.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maxima.chat.config.PostgresDbTestcontainers;
import com.maxima.chat.entity.MessageEntity;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * Тестирование репозитория для работы с сообщениями
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование репозитория для работы с пользователями")
@Import(PostgresDbTestcontainers.class)
class MessageRepositoryTest {

  @Autowired
  private MessageRepository messageRepository;

  @Test
  @DisplayName("Получение списка сообщений, проблема n + 1")
  void shouldGetList() {
    List<MessageEntity> messages = messageRepository.findAll();

    assertThat(messages).isNotEmpty();
    assertEquals(5, messages.size());
  }

  @Test
  @DisplayName("Получение сообщения по id")
  void shouldGetById() {
    var id = 1;
    var message = messageRepository.findById(id).orElse(null);

    assertThat(message).isNotNull();
    assertEquals(id, message.getId().longValue());
  }

  @Test
  @DisplayName("Проверка запроса с решенной n + 1 проблемой")
  void shouldResolveNplusOneProblem() {
    List<MessageEntity> messages = messageRepository.findAllCustom();

    assertThat(messages).isNotEmpty();
    assertEquals(5, messages.size());
  }
}
