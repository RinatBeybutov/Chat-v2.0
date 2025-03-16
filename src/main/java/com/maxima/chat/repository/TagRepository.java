package com.maxima.chat.repository;

import com.maxima.chat.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с таблицей тегов
 */
public interface TagRepository extends JpaRepository<TagEntity, Integer> {
}
