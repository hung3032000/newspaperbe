package com.hungpham.mappers;

import com.hungpham.dtos.UserDto;
import com.hungpham.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto userDtos);
    UserDto toDto(UserEntity userEntity);
}
