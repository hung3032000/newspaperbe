package com.hungpham.service.impl;

import com.hungpham.common.exception.BadRequestException;
import com.hungpham.dtos.CategoryDto;
import com.hungpham.entity.CategoryEntity;
import com.hungpham.mappers.CategoryMapper;
import com.hungpham.repository.CategoriesRepository;
import com.hungpham.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryEntity> getAllCategories() {
        logger.info("Start get all category");
        return categoriesRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoryById(String id) {
        logger.info("Find category id {}", id);
        return categoriesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found " + id));
    }

    @Override
    public CategoryEntity createCategory(CategoryDto categoryDto) {
        UUID uuid = UUID.randomUUID();
        categoryDto.setId(String.valueOf(uuid));
        categoryDto.setCreatedDate(new Date());
        logger.info("New category data {}", categoryDto);
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryDto);
        return categoriesRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(CategoryDto categoryDto) {
        logger.info("Update category id {}", categoryDto.getId());
        if (null == categoryDto.getId()) {
            throw new BadRequestException("Not found category id to update");
        }
        CategoryEntity categoryEntity = categoriesRepository.findById(categoryDto.getId()).orElseThrow(
                ()-> new EntityNotFoundException("News not found " + categoryDto.getId()));
        logger.info("Category data is {}", categoryDto);
        categoryDto.setCreatedDate(categoryEntity.getCreatedDate());
        categoryDto.setUpdatedDate(new Date());
        CategoryEntity finalNewEntity = categoryMapper.toEntity(categoryDto);
        return categoriesRepository.save(finalNewEntity);
    }

    @Override
    public CategoryEntity deleteCategory(String id) {
        logger.info("Delete category id {}", id);
        CategoryEntity categoryEntity = categoriesRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("News not found " + id));
        categoryEntity.setDeleteFlag(true);
        categoryEntity.setUpdatedDate(new Date());
        return categoriesRepository.save(categoryEntity);
    }
}
