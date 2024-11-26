package com.breadflow.app.orders.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.breadflow.app.orders.service.OrdersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrdersController {
	private final OrdersService ordersService;
	
	@GetMapping("/orders/insert")
	public String ordersInsert() {
		return "orders/insert";
	}
	
}
