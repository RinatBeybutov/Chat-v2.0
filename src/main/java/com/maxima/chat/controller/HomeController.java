package com.maxima.chat.controller;

import com.maxima.chat.dto.UserCreateDto;
import com.maxima.chat.service.MessageService;
import com.maxima.chat.service.UserService;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер для работы с главной страницей
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

  private final MessageService messageService;

  private final UserService userService;

  /**
   * Получение главной страницы
   *
   * @param model Модель для передачи данных в html шаблон
   * @return Имя html шаблона
   */
  @GetMapping("/")
  public String index(Model model, Principal principal) {
    var list = messageService.getListForView(principal);
    model.addAttribute("messages", list);
    return "index";
  }

  /**
   * Добавление сообщения в бд
   *
   * @param message Сообщение
   * @return Перенаправление на главную страницу
   */
  @PostMapping("/message")
  public String addMessage(@RequestParam("message") String message, Principal principal) {
    messageService.addMessage(message, principal.getName());
    return "redirect:/";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/registration")
  public String registration(Model model) {
    model.addAttribute("user", new UserCreateDto());
    return "registration";
  }

  @PostMapping("/registration")
  public String addUser(UserCreateDto user) {
    userService.create(user);
    return "redirect:/login";
  }
}
