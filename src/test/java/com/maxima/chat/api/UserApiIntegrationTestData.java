package com.maxima.chat.api;

import com.maxima.chat.dto.UserViewDto;

/**
 * Тестовы данные для тестирования API {@link UserController}
 */
public class UserApiIntegrationTestData {

  /**
   * Представление пользователя для тестирования
   */
  public static UserViewDto getUserViewDto() {
    UserViewDto dto = new UserViewDto();
    dto.setId(1);
    dto.setName("Gabe");
    dto.setEmail("gabe@maxima.com");
    return dto;
  }
}
