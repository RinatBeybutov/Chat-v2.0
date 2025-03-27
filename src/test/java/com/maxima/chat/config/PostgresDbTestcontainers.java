package com.maxima.chat.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Конфигурационный класс для контейнера PostgreSQL
 */
@TestConfiguration
public class PostgresDbTestcontainers {

  static final PostgreSQLContainer<?> postgresContainer =
      new PostgreSQLContainer<>("postgres:15-alpine");

  static {
    postgresContainer.start();
    System.setProperty("spring.datasource.url", postgresContainer.getJdbcUrl());
    System.setProperty("spring.datasource.username", postgresContainer.getUsername());
    System.setProperty("spring.datasource.password", postgresContainer.getPassword());

    System.setProperty("spring.flyway.url", postgresContainer.getJdbcUrl());
    System.setProperty("spring.flyway.user", postgresContainer.getUsername());
    System.setProperty("spring.flyway.password", postgresContainer.getPassword());
  }

}
