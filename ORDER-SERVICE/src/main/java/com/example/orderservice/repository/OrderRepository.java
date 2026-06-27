package com.example.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.model.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer>{

	Long countByUserIdAndOrderStatus(Integer userId, String orderStatus);
	
	
}
