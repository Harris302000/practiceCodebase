package com.example.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.model.OrderDetails;
import com.example.orderservice.service.OrderConfirmService;
import com.example.orderservice.service.OrderHistoryService;

import jakarta.persistence.criteria.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderHistoryService historyService;
	
	@Autowired
	OrderConfirmService confirmService;
	
	@PostMapping("/confirm-order")
	public String addOrderDetails(@RequestBody OrderDetails orderDetails) {
		
		return confirmService.addOrderDetails(orderDetails);
	}
	
	
	@GetMapping("/all-orders")
	public List<OrderDetails> fetchAllOrders() {
		
		return historyService.fetchAllOrders();
	}

	
	@GetMapping("/all-ordersCount")
	public Long fetchAllOrdersCount() {
		
		return historyService.fetchAllOrdersCount();
	}
	
	@GetMapping("/ordersCountByUserID")
	public Long getallordercountByUserID(@RequestParam Integer userid ,@RequestParam String status) {
		
		
		return historyService.getallordercountByUserID(userid,status);
	}
	
}
