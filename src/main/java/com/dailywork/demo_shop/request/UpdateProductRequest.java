package com.dailywork.demo_shop.request;

import java.math.BigDecimal;

import com.dailywork.demo_shop.model.CategoryEntity;

import lombok.Data;

@Data
public class UpdateProductRequest {	
	private Long id;
	private String brand;
	private String name;
	private BigDecimal price;
	private int inventory;
	private String description;
	private CategoryEntity category;
}
