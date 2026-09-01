package com.foodapp.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.foodapp.dto.OrderDTO;

@FeignClient(name = "ORDERS-SERVICES")

public interface OrderClient {
	
	@GetMapping("/foodapp/user/allOrders")
	public List<OrderDTO> allOrders();

}
