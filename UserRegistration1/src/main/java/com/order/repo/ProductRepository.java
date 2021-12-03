package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.Products;


public interface ProductRepository extends JpaRepository<Products,Integer>{

}
