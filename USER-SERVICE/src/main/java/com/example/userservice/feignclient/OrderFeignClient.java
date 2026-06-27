package com.example.userservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderFeignClient {
	
	@GetMapping("/order/ordersCountByUserID")
	public Long getallordercountByUserID(@RequestParam Integer userid ,@RequestParam String status) ;
}
