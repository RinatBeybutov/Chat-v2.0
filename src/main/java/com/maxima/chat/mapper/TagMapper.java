package com.maxima.chat.mapper;

import com.maxima.chat.dto.TagViewDto;
import com.maxima.chat.entity.TagEntity;
import org.mapstruct.Mapper;

/**
 * Маппер для преобразования тегов
 */
@Mapper(componentModel = "spring")
public interface TagMapper {

  TagViewDto toDto(TagEntity tagEntity);
}
