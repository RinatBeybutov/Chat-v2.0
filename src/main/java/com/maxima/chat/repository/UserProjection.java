package com.maxima.chat.repository;

/**
 * Интерфейс проекции для получения части данных пользователя
 */
public interface UserProjection {
  Integer getId();

  String getName();
}
