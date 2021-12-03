package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.model.Products;
import com.order.repo.ProductRepository;


@Component
public class Productimplementation {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Products> getProducts(){
		return productRepository.findAll();
	}
	
	public void saveProducts(Products products ) {
		productRepository.save(products);
	}
	
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}
	
	public Products getProduct(Integer id) {
		return productRepository.findById(id).get();
	}
}
