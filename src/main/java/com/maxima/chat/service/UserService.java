package com.maxima.chat.service;

import com.maxima.chat.dto.UserCreateDto;
import com.maxima.chat.dto.UserViewDto;
import com.maxima.chat.entity.CityEntity;
import com.maxima.chat.entity.UserEntity;
import com.maxima.chat.mapper.UserMapper;
import com.maxima.chat.repository.CityRepository;
import com.maxima.chat.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для работы с пользователями
 */
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  private final CityRepository cityRepository;

  private final UserMapper mapper;

  /**
   * Получение списка пользователей из бд
   */
  @Transactional(readOnly = true)
  public List<UserViewDto> getList() {
    return repository.findAll()
        .stream()
        .map(mapper::toDto)
        .toList();
  }

  /**
   * Создание пользователя в бд
   */
  @Transactional
  public void create(UserCreateDto userDto) {
    UserEntity user = new UserEntity();
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());

    CityEntity defaultCity = cityRepository.findAll().get(0);
    user.setCity(defaultCity);
    repository.save(user);
  }
}
