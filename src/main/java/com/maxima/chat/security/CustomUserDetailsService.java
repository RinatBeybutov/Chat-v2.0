package com.maxima.chat.security;

import com.maxima.chat.entity.UserEntity;
import com.maxima.chat.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Класс для загрузки пользователя по email.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    log.info("Попытка авторизации пользователя с email {}", email);
    Optional<UserEntity> user = userRepository.findByEmail(email);
    if (user.isEmpty()) {
      log.error("Пользователь с email {} не найден", email);
      throw new UsernameNotFoundException("Пользователь с email %s не найден!".formatted(email));
    }
    return new CustomUserDetails(user.get());
  }
}
