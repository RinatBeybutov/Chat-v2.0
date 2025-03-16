package com.maxima.chat.error;

/**
 * Класс ошибки при отсутствии сущности в базе
 */
public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(String message) {
    super(message);
  }
}
