package com.maxima.chat.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MessageViewDto {

  private String message;
  private boolean isMine;
  private LocalDateTime createdAt;

}
