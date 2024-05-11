package com.hungpham.mappers;

import com.hungpham.dtos.NewsDto;

import com.hungpham.entity.NewsEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsEntity toEntity(NewsDto newsDto);
    NewsDto toDto(NewsEntity newsEntity);
}
