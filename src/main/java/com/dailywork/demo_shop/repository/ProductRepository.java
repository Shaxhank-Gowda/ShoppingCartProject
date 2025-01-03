package com.dailywork.demo_shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailywork.demo_shop.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByCategoryName(String category);

	List<ProductEntity> findByBrandName(String brand);

	List<ProductEntity> findByName(String name);

	List<ProductEntity> findByCategoryAndBrandName(String category, String brand);

	List<ProductEntity> findByBrandAndName(String brand, String name);

	Long countByBrandAndName(String brand, String name);

}
