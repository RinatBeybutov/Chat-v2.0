package com.maxima.chat.restController;

import static com.maxima.chat.config.API.MESSAGES;

import com.maxima.chat.dto.MessageViewDto;
import com.maxima.chat.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Рест контроллер для работы с сообщениями
 */
@RestController
@RequestMapping(MESSAGES)
@RequiredArgsConstructor
@Tag(name = "Сообщения", description = "Операции по работе с сообщениями")
public class MessageController {

  private final MessageService messageService;

  @GetMapping
  @Operation(summary = "Получение списка сообщений")
  public ResponseEntity<List<MessageViewDto>> getList() {
    return ResponseEntity.ok(messageService.getList());
  }

}
