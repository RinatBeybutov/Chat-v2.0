package com.maxima.chat.api;

import static com.maxima.chat.api.UserApiIntegrationTestData.getUserViewDto;
import static com.maxima.chat.config.API.USERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.maxima.chat.config.PostgresDbTestcontainers;
import com.maxima.chat.dto.UserViewDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

/**
 * Интеграционный тест для сущности {@link com.maxima.chat.entity.UserEntity}
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование API для работы с пользователями")
@Import(PostgresDbTestcontainers.class)
@ActiveProfiles("test")
class UserApiIntegrationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @DisplayName("Проверка получения списка пользователей")
  void shouldGetList() {
    var response = restTemplate.getForEntity(USERS, UserViewDto[].class);

    assertEquals(HttpStatus.OK, response.getStatusCode());

    UserViewDto[] users = response.getBody();
    assertNotNull(users);

    assertEquals(5, users.length);

    assertThat(users[0])
        .usingRecursiveComparison()
        .isEqualTo(getUserViewDto());
  }
}
