package com.dailywork.demo_shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailywork.demo_shop.model.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	List<CategoryEntity> findByCategoryName(String category);

	List<CategoryEntity> findByBrandName(String brand);

	CategoryEntity findByName(String name);

	List<CategoryEntity> findByCategoryAndBrandName(String category, String brand);

	List<CategoryEntity> findByBrandAndName(String brand, String name);

	Long countByBrandAndName(String brand, String name);

}
