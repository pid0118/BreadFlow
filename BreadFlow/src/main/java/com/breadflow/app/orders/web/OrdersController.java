package com.breadflow.app.orders.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.orders.service.OrdersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrdersController {
	private final OrdersService ordersService;
	
	// 주문 신청 페이지(본사)
	@GetMapping("/orders/insert")
	public String ordersInsert() {
		return "orders/insert";
	}
	
	// 주문 신청 목록
	@GetMapping("/orders/list")
	@ResponseBody
	public Map<String, Object> ordersList(){
		return ordersService.selectOrdersList();
	}
	
	// 주문 신청 상세 목록
	@GetMapping("/orders/detailList")
	@ResponseBody
	public Map<String, Object> ordersDetailList(@RequestParam String code){
		return ordersService.selectOrdersDetailList(code);
	}
	
	// 선택된 주문 신청 상세 리스트
	@GetMapping("/orders/reqDetailList")
	@ResponseBody
	public Map<String, Object> ordersReqDetailList(@RequestParam String codes){
		return ordersService.selectOrdersRequestList(codes);
	}
	
}
