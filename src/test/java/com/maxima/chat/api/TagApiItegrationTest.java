package com.maxima.chat.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maxima.chat.config.PostgresDbTestcontainers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

/**
 * Интеграционный тест для сущности {@link com.maxima.chat.entity.TagEntity}
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование API для работы с тегами")
@Import(PostgresDbTestcontainers.class)
class TagApiItegrationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @DisplayName("Проверка получения списка пользователей")
  void shouldGetList() {
    var id = 10;
    var response = restTemplate.exchange("/tags/" + id,
                                         HttpMethod.DELETE,
                                         null,
                                         String.class);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    var errorMessage = response.getBody();

    assertThat(errorMessage)
        .isEqualTo("Тег c id %d не найден", id);
  }
}
