package com.maxima.chat.controller;

import com.maxima.chat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

  private final MessageService messageService;

  @GetMapping("/")
  public String index(Model model) {
    var list = messageService.getList();
    model.addAttribute("messages", list);
    return "index";
  }

  @PostMapping("/message")
  public String addMessage(@RequestParam("message") String message) {
    messageService.addMessage(message);
    return "redirect:/";
  }

  /**
   * @PostMapping("/send-message")
   * public String handleMessage(@RequestParam("message") String message, Model model) {
   *     // Логика обработки сообщения
   *     System.out.println("Полученное сообщение: " + message);
   *     // Возвращаем страницу обратно после отправки сообщения
   *     return "redirect:/chat";
   * }
   */
}
