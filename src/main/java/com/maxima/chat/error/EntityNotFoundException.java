package com.maxima.chat.error;

import lombok.Getter;

/**
 * Класс ошибки при отсутствии сущности в базе
 */
@Getter
public class EntityNotFoundException extends RuntimeException {

  private final Object[] args;

  public EntityNotFoundException(String message, Object... args) {
    super(message);
    this.args = args;
  }
}
