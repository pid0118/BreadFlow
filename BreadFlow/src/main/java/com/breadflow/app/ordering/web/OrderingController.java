package com.breadflow.app.ordering.web;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.ordering.service.OrderingDetailsVO;
import com.breadflow.app.ordering.service.OrderingService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderingController {
	private final OrderingService orderingService;
	
	// 발주 신청 페이지
	@GetMapping("/ordering/insert")
	public String insertForm() {
		return "ordering/insert";
	}
	
	// 발주 신청 처리
	@PostMapping("/ordering/insert")
	@ResponseBody
	public String insertOrdering(@RequestBody Map<String, Object> ordering, HttpSession session) {
		orderingService.insertOrdering(ordering, session);
		return "/order/list";
	}
	
	// 발주/주문 현황 페이지
	@GetMapping("/order/list")
	public String orderListPage(Model model) {
		return "ordering/orderlist";
	}
	
	// 발주 현황 조회
	@GetMapping("/ordering/list")
	@ResponseBody
	public Map<String, Object> selectOrderList(@RequestParam("status") String status, 
			                                   @RequestParam(name = "sort", required = false) String sort, 
			                                   @RequestParam(name = "page", defaultValue = "1") int page,
			                                   HttpSession session){
		Map<String, Object> map = orderingService.selectOrderingList(status, sort, page, session);
		return map;
	}
	
	// 발주 요청 거절 처리
	@PostMapping("/ordering/updateOdCancel")
	@ResponseBody
	public Map<String,Boolean> updateOrderingCancel(@RequestParam("no") String no, 
			                           @RequestParam("reason") String reason) {
		orderingService.updateOrderingApprovalCancel(no, reason);
		return Collections.singletonMap("result", true);
	}
	
	// 발주 요청 승인 처리
	@PostMapping("/ordering/updateOdAccept")
	@ResponseBody
	public ResponseEntity updateOrderingAccept(@RequestParam("code") String code) {
		orderingService.updateOrderingAccept(code);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 발주 상세 내역 조회
	@GetMapping("/ordering/detailList")
	@ResponseBody
	public List<OrderingDetailsVO> selectOrderingDeatilList(@RequestParam String orderingCode, HttpSession session){
		return orderingService.selectOrderingDetailList(orderingCode, session);
	}
	
}
