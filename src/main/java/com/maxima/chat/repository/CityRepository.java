package com.maxima.chat.repository;

import com.maxima.chat.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с таблицей городов
 */
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

}
