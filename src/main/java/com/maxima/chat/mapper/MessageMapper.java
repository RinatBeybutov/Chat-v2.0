package com.maxima.chat.mapper;

import com.maxima.chat.dto.MessageViewDto;
import com.maxima.chat.entity.MessageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Маппер для преобразования сообщений
 */
@Mapper(componentModel = "spring")
public interface MessageMapper {

  @Mapping(target = "mine", expression = "java(messageEntity.getUserId().equals(1))")
  @Mapping(target = "message", expression = "java(messageEntity.getUser().getName().substring(0, 3) + \" : \"+ messageEntity.getMessage())")
  MessageViewDto toDto(MessageEntity messageEntity);
}
