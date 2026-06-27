package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.model.OrderDetails;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderConfirmService {

	@Autowired
	OrderRepository orderRepository;
	
	
	public String addOrderDetails(OrderDetails orderDetails) {

		orderRepository.save(orderDetails);

		return "Order Placed Sucessfully";
	}

}
