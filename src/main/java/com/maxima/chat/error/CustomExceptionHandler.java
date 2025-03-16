package com.maxima.chat.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Класс обработки ошибок контроллеров
 */
@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = EntityNotFoundException.class)
  public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e) {
    return ResponseEntity.badRequest().body("Сущность не найдена!");
  }
}
