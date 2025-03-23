package com.maxima.chat.dto;

import lombok.Data;

/**
 * Модель создания пользователя
 */
@Data
public class UserCreateDto {

  private String name;
  private String email;
  private String password;
  private String confirmPassword;
}
