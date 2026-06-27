package com.example.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.orderservice.model.OrderDetails;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderHistoryService {

	@Autowired
	OrderRepository orderRepository;
	
	public List<OrderDetails> fetchAllOrders() {

		return orderRepository.findAll();

	}

	public Long fetchAllOrdersCount() {

		return orderRepository.count();
	}

	public Long getallordercountByUserID(Integer userid, String status) {

		return orderRepository.countByUserIdAndOrderStatus(userid, status);
	}
}
