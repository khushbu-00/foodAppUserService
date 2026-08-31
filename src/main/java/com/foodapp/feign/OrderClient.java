package com.foodapp.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.foodapp.dto.OrderDTO;

@FeignClient
(
		name = "ORDER-SERVICE"
		
)
public interface OrderClient {
	
	@GetMapping("/foodapp/user/allOrders")
	List<OrderDTO>getAllOrders();

}
