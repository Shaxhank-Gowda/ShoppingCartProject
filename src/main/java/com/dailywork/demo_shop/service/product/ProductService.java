package com.dailywork.demo_shop.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dailywork.demo_shop.exceptions.ProductNotFoundExcception;
import com.dailywork.demo_shop.model.ProductEntity;
import com.dailywork.demo_shop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

	private final ProductRepository productRepo;
	@Override
	public ProductEntity addProduct(ProductEntity ProductEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductEntity getProductById(Long id) {
		return productRepo.findById(id)
				.orElseThrow(()-> new ProductNotFoundExcception("Product not found!"));
		}

	@Override
	public void deleteProductById(Long id) {
		productRepo.findById(id).ifPresentOrElse(productRepo::delete, 
				()-> new ProductNotFoundExcception("Product not found!"));
	}

	@Override
	public void updateProductEntity(ProductEntity ProductEntity, Long productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductEntity> getAllProducts() {
			return productRepo.findAll();
	}

	@Override
	public List<ProductEntity> getProductsByCategory(String category) {
		return productRepo.findByCategoryName(category);
	}

	@Override
	public List<ProductEntity> getProductsByBrand(String brand) {
		return productRepo.findByBrandName(brand);
	}

	@Override
	public List<ProductEntity> getProductsByCategoryAndBrand(String category, String brand) {
		// TODO Auto-generated method stub
		return productRepo.findByCategoryAndBrandName(category,brand);
	}

	@Override
	public List<ProductEntity> getProductsByName(String name) {
		return productRepo.findByName(name);
	}

	@Override
	public List<ProductEntity> getProductsByBrandAndName(String brand, String name) {
		return productRepo.findByBrandAndName(brand,name);
	}

	@Override
	public Long countProductsByBrandAndName(String brand, String name) {
		return productRepo.countByBrandAndName(brand,name);
	}

}
