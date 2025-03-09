package com.maxima.chat.service;

import com.maxima.chat.dto.MessageViewDto;
import com.maxima.chat.entity.MessageEntity;
import com.maxima.chat.mapper.MessageMapper;
import com.maxima.chat.repository.MessageRepository;
import com.maxima.chat.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для работы с сообщениями.
 *
 * @author Gaben
 */
@Service
@RequiredArgsConstructor
public class MessageService {

  private final MessageRepository repository;

  private final MessageMapper mapper;

  private final UserRepository userRepository;

  /**
   * Получение списка сообщений из бд
   *
   * @return список сообщений
   */
  @Transactional(readOnly = true)
  public List<MessageViewDto> getList() {
    return repository.findAll()
        .stream()
        .map(mapper::toDto)
        .toList();
  }

  /**
   * Добавление сообщения в бд
   */
  @Transactional
  public void addMessage(String message) {
    var user = userRepository.findById(1).get();

    MessageEntity messageEntity = new MessageEntity();
    messageEntity.setUser(user);
    messageEntity.setMessage(message);
    messageEntity.setCreatedAt(LocalDateTime.now());

    repository.save(messageEntity);
  }
}
