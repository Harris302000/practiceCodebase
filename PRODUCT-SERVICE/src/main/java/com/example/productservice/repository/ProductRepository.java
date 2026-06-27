package com.example.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productservice.model.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails, Integer>{

}
