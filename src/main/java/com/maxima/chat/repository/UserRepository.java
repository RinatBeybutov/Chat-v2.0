package com.maxima.chat.repository;

import com.maxima.chat.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Репозиторий для работы с таблицей пользователей
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  List<UserEntity> findAllByNameContainingIgnoreCase(String username);

  List<UserEntity> findAllByIdGreaterThan(Integer id);

  @Query(nativeQuery = true, value = "select * from users where name = :username")
  List<UserEntity> findAllByNameNative(String username);

  // JPQL - java persistence query language
  @Query(value = """
      select u from UserEntity u
      where u.name = :username
      """)
  List<UserEntity> findAllByNameHql(String username);

  @Query(value = "select u.id AS id, u.name AS name from UserEntity u")
  List<UserProjection> findAllByProjection();

  Optional<UserEntity> findByEmail(String email);
}
