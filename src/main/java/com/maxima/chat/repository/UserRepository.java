package com.maxima.chat.repository;

import com.maxima.chat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с таблицей пользователей
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
