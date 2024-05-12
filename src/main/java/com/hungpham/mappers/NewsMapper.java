package com.hungpham.mappers;

import com.hungpham.dtos.NewsDto;
import com.hungpham.entity.NewsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface NewsMapper {
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "category", ignore = true)
    NewsEntity toEntity(NewsDto newsDto);
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "categoryName", ignore = true)
    NewsDto toDto(NewsEntity newsEntity);
}
