package com.maxima.chat.restController;

import static com.maxima.chat.config.API.USERS;

import com.maxima.chat.dto.UserViewDto;
import com.maxima.chat.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Рест контроллер для работы с пользователями
 */
@RestController
@RequestMapping(USERS)
@RequiredArgsConstructor
@Tag(name = "Пользователи", description = "Операции по работе с пользователями")
public class UserController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<UserViewDto>> getList() {
    return ResponseEntity.ok(userService.getList());
  }
}
