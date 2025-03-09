package com.maxima.chat.controller;

import com.maxima.chat.service.MessageService;
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

  /**
   * Получение главной страницы
   * @param model Модель для передачи данных в html шаблон
   * @return Имя html шаблона
   */
  @GetMapping("/")
  public String index(Model model) {
    var list = messageService.getList();
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
  public String addMessage(@RequestParam("message") String message) {
    messageService.addMessage(message);
    return "redirect:/";
  }
}
