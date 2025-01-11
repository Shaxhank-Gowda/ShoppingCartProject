package com.dailywork.demo_shop.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductEntity {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String name;
	private BigDecimal price;
	private int inventory;
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "xCategoryId")
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true )
	private List<ImageEntity> images;

	public ProductEntity(String brand, String name, BigDecimal price, int inventory, String description,
			CategoryEntity category) {
		super();
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
		this.description = description;
		this.category = category;
	}
	
	
}
