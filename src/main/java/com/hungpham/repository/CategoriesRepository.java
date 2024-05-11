package com.hungpham.repository;


import com.hungpham.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<CategoryEntity, String> {
}
