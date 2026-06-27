package com.example.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.model.ProductDetails;
import com.example.productservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<ProductDetails> fetchallproducts() {

		return productRepository.findAll();

	}

}
