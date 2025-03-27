package com.maxima.chat.service;

import com.maxima.chat.dto.MessageViewDto;
import com.maxima.chat.entity.MessageEntity;
import com.maxima.chat.entity.UserEntity;
import com.maxima.chat.error.EntityNotFoundException;
import com.maxima.chat.mapper.MessageMapper;
import com.maxima.chat.repository.MessageRepository;
import com.maxima.chat.repository.UserRepository;
import java.security.Principal;
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
  public List<MessageViewDto> getListForView(Principal principal) {
    UserEntity user = findUserByEmail(principal.getName());
    Integer userId = user.getId();
    return repository.findAll()
        .stream()
        .map(messageEntity -> mapper.toDto(messageEntity, userId))
        .toList();
  }

  /**
   * Получение списка сообщений из бд
   *
   * @return список сообщений
   */
  @Transactional(readOnly = true)
  public List<MessageViewDto> getListForRest() {
    return repository.findAll()
        .stream()
        .map(messageEntity -> mapper.toDto(messageEntity, 1))
        .toList();
  }

  /**
   * Добавление сообщения в бд
   */
  @Transactional
  public void addMessage(String message, String userEmail) {
    UserEntity user = findUserByEmail(userEmail);

    MessageEntity messageEntity = new MessageEntity();
    messageEntity.setUser(user);
    messageEntity.setMessage(message);
    messageEntity.setCreatedAt(LocalDateTime.now());

    repository.save(messageEntity);
  }

  private UserEntity findUserByEmail(String principal) {
    return userRepository.findByEmail(principal)
        .orElseThrow(() -> new EntityNotFoundException("User not found"));
  }
}
