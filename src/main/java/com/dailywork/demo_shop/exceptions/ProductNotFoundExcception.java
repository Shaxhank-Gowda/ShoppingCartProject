package com.dailywork.demo_shop.exceptions;

public class ProductNotFoundExcception extends RuntimeException{

	public ProductNotFoundExcception(String message){
		super(message);
	}
}
