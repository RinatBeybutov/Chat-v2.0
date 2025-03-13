package com.maxima.chat.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Дто для просмотра сообщений
 */
@Data
public class MessageViewDto {

  @Schema(description = "Сообщение пользователя")
  private String message;
  @Schema(description = "Флаг принадлежности сообщения пользователю")
  private boolean isMine;
  @Schema(description = "Дата и время создания сообщения")
  private LocalDateTime createdAt;

}
