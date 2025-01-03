package com.dailywork.demo_shop.service.product;
import java.util.List;

import com.dailywork.demo_shop.model.ProductEntity;
public interface IProductService {

	ProductEntity addProduct (ProductEntity ProductEntity); 
	ProductEntity getProductById(Long id); 
	void deleteProductById(Long id); 
	void updateProductEntity (ProductEntity ProductEntity, Long productId); 
	List<ProductEntity> getAllProducts(); 
	List<ProductEntity> getProductsByCategory(String category); 
	List<ProductEntity> getProductsByBrand(String brand); 
	List<ProductEntity> getProductsByCategoryAndBrand(String category, String brand); 
	List<ProductEntity> getProductsByName(String name); 
	List<ProductEntity> getProductsByBrandAndName(String category, String name); 
	Long countProductsByBrandAndName(String brand, String name); 
}
