package com.maxima.chat.mapper;

import com.maxima.chat.dto.UserViewDto;
import com.maxima.chat.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserViewDto toDto(UserEntity userEntity);
}
