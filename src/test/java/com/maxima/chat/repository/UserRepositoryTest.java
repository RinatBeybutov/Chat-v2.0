package com.maxima.chat.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.maxima.chat.config.PostgresDbTestcontainers;
import com.maxima.chat.entity.UserEntity;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

/**
 * Тестирование репозитория для работы с пользователями
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование репозитория для работы с пользователями")
public class UserRepositoryTest extends PostgresDbTestcontainers {

  @Autowired
  private UserRepository userRepository;

  @Test
  @DisplayName("Получение списка пользователей")
  void shouldGetList() {
    List<UserEntity> users = userRepository.findAll();

    assertThat(users).isNotEmpty();
    assertEquals(5, users.size());
  }

  @Test
  @DisplayName("Получение списка пользователей с определённой частью имени")
  void shouldGetListContainingNameIgnoreCase() {
    List<UserEntity> users = userRepository.findAllByNameContainingIgnoreCase("Gabe");

    assertThat(users).isNotEmpty();
    assertEquals(1, users.size());
  }

  @Test
  @DisplayName("Получение списка пользователей с определённой частью имени")
  void shouldGetListGreaterThan3() {
    List<UserEntity> users = userRepository.findAllByIdGreaterThan(3);

    assertThat(users).isNotEmpty();
    assertEquals(2, users.size());
  }

  @Test
  @DisplayName("Получение списка пользователей с определённой частью имени (Native Query)")
  void shouldGetListContainingNameNative() {
    List<UserEntity> users = userRepository.findAllByNameNative("Gabe");

    assertThat(users).isNotEmpty();
    assertEquals(1, users.size());
  }

  @Test
  @DisplayName("Получение списка пользователей с определённой частью имени (HQL Query)")
  void shouldGetListContainingNameHql() {
    List<UserEntity> users = userRepository.findAllByNameHql("Gabe");

    assertThat(users).isNotEmpty();
    assertEquals(1, users.size());
  }

  @Test
  @DisplayName("Получение списка пользователей с определённой частью имени (HQL Query)")
  void shouldGetListPagination() {
    PageRequest pageable = PageRequest.of(1, 2)
        .withSort(Direction.DESC, "id");
    Page<UserEntity> page = userRepository.findAll(pageable);

    List<UserEntity> users = page.getContent();

    assertThat(users).isNotEmpty();
    assertEquals(2, users.size());
  }

  @Test
  @DisplayName("Получение списка пользователей через проекцию")
  void shouldGetListByProjection() {
    List<UserProjection> users = userRepository.findAllByProjection();

    assertThat(users).isNotEmpty();
    assertEquals(5, users.size());

    Assertions.assertEquals(1, users.getFirst().getId());
  }
}
