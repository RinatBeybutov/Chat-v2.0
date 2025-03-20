package com.maxima.chat.service;

import com.maxima.chat.dto.UserViewDto;
import com.maxima.chat.mapper.UserMapper;
import com.maxima.chat.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с пользователями
 */
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  private final UserMapper mapper;

  public List<UserViewDto> getList() {
    return repository.findAll()
        .stream()
        .map(mapper::toDto)
        .toList();
  }
}
