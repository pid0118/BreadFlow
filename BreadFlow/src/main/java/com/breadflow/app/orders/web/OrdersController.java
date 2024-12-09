package com.breadflow.app.orders.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.orders.service.OrdersResponseVO;
import com.breadflow.app.orders.service.OrdersService;

import jakarta.servlet.http.HttpSession;
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
	
	// 주문 신청 처리
	@PostMapping("/orders/request")
	@ResponseBody
	public String ordersRequest(@RequestBody List<OrdersResponseVO> responseVO, HttpSession session) {
		return ordersService.insertOrders(responseVO, session);
	}
	
	// 주문 현황 데이터 조회
	@GetMapping("/orders/ordersComList")
	@ResponseBody
	public Map<String, Object> ordersComList(@RequestParam String sort, 
											 @RequestParam int page,
											 HttpSession session){
		return ordersService.selectOrdersComList(sort, page, session);
	}
	
	// 주문 상세 현황 조회
	@GetMapping("/orders/detailComList")
	@ResponseBody
	public Map<String, Object> ordersComDetailList(@RequestParam String no){
		return ordersService.selectOrdersComDList(no);
	}
	
}
