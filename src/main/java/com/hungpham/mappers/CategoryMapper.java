package com.hungpham.mappers;

import com.hungpham.dtos.CategoryDto;
import com.hungpham.dtos.NewsDto;
import com.hungpham.entity.CategoryEntity;
import com.hungpham.entity.NewsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity toEntity(CategoryDto categoryDto);
    CategoryDto toDto(CategoryEntity categoryEntity);
}
