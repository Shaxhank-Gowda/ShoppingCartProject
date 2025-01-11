package com.dailywork.demo_shop.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dailywork.demo_shop.exceptions.ProductNotFoundExcception;
import com.dailywork.demo_shop.model.CategoryEntity;
import com.dailywork.demo_shop.model.ProductEntity;
import com.dailywork.demo_shop.repository.CategoryRepository;
import com.dailywork.demo_shop.repository.ProductRepository;
import com.dailywork.demo_shop.request.AddProductRequest;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	@Override
	public ProductEntity addProduct(AddProductRequest request) {
				
		CategoryEntity category = Optional.ofNullable(categoryRepo.findByName(request.getCategory().getName()))
				.orElseGet(()-> {
						CategoryEntity newCategory = new CategoryEntity(request.getCategory().getName());
								return categoryRepo.save(newCategory);								
				});
		request.setCategory(category);
		return productRepo.save(createProduct(request, category));
	}

	private ProductEntity createProduct(AddProductRequest req, CategoryEntity category) {		
		return new ProductEntity(
				req.getBrand(),
				req.getName(),
				req.getPrice(),
				req.getInventory(),
				req.getDescription(),
				category);		
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
	
	private ProductEntity updateExistingProduct(ProductEntity)

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
