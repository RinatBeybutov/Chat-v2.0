package com.maxima.chat.error;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Класс обработки ошибок контроллеров
 */
@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

  private final MessageSource messageSource;

  @ExceptionHandler(value = EntityNotFoundException.class)
  public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e) {
    String message = messageSource.getMessage(e.getMessage(), e.getArgs(), Locale.getDefault());
    return ResponseEntity.badRequest().body(message);
  }
}
