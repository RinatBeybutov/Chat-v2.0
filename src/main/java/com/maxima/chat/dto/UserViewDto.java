package com.maxima.chat.dto;

import lombok.Data;

/**
 * Модель представления пользователя
 */
@Data
public class UserViewDto {

  private Integer id;
  private String name;
  private String email;
}
