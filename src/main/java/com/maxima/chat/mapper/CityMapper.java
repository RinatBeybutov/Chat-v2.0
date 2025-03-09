package com.maxima.chat.mapper;

import com.maxima.chat.dto.CityCreateDto;
import com.maxima.chat.dto.CityViewDto;
import com.maxima.chat.entity.CityEntity;
import org.mapstruct.Mapper;

/**
 * Маппер для преобразования городов
 */
@Mapper(componentModel = "spring")
public interface CityMapper {

  CityViewDto toDto(CityEntity cityEntity);

  CityEntity toEntity(CityCreateDto dto);
}
