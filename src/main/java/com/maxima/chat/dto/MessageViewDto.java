package com.maxima.chat.dto;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * Дто для просмотра сообщений
 */
@Data
public class MessageViewDto {

  private String message;
  private boolean isMine;
  private LocalDateTime createdAt;

}
