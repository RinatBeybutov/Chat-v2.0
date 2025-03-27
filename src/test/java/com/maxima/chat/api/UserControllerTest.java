package com.maxima.chat.api;

import static com.maxima.chat.config.API.USERS;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxima.chat.config.SecurityConfig;
import com.maxima.chat.dto.UserViewDto;
import com.maxima.chat.restController.UserController;
import com.maxima.chat.service.UserService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Тестирование контроллера пользователей
 */
@WebMvcTest(UserController.class)
@DisplayName("Тестирование контроллера пользователей")
@ActiveProfiles("test")
@Import(SecurityConfig.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private UserService userService;

  @Test
  @DisplayName("Проверка получения списка пользователей")
  void getList() throws Exception {
    var list = List.of(dto1(), dto2());
    when(userService.getList()).thenReturn(list);

    mockMvc.perform(get(USERS).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(list)));
  }

  private UserViewDto dto1() {
    UserViewDto dto = new UserViewDto();
    dto.setId(1);
    dto.setName("Name");
    dto.setEmail("abc@mail.ri");
    return dto;
  }

  private UserViewDto dto2() {
    UserViewDto dto = new UserViewDto();
    dto.setId(2);
    dto.setName("Gaben");
    dto.setEmail("gabe@mail.ri");
    return dto;
  }
}
