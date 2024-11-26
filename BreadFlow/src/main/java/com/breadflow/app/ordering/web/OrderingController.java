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

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderingController {
	private final OrderingService orderingService;
	
	@GetMapping("/ordering/insert")
	public String insertForm() {
		return "ordering/insert";
	}
	
	@PostMapping("/ordering/insert")
	public String insertOrdering(@RequestBody Map<String, Object> ordering) {
		orderingService.insertOrdering(ordering);
		return "redirect:/order/list";
	}
	
	@GetMapping("/order/list")
	public String orderListPage(Model model) {
		return "ordering/orderlist";
	}
	
	@GetMapping("/ordering/list")
	@ResponseBody
	public Map<String, Object> selectOrderList(@RequestParam("status") String status, 
			                                   @RequestParam(name = "sort", required = false) String sort, 
			                                   @RequestParam(name = "page", defaultValue = "1") int page){
		Map<String, Object> map = orderingService.selectOrderingList(status, sort, page);
		return map;
	}
	
	
	@PostMapping("/ordering/updateOdCancel")
	@ResponseBody
	public Map<String,Boolean> updateOrderingCancel(@RequestParam("no") String no, 
			                           @RequestParam("reason") String reason) {
		orderingService.updateOrderingApprovalCancel(no, reason);
		return Collections.singletonMap("result", true);
	}
	
	@PostMapping("/ordering/updateOdAccept")
	@ResponseBody
	public ResponseEntity updateOrderingAccept(@RequestParam("code") String code) {
		orderingService.updateOrderingAccept(code);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/ordering/detailList")
	@ResponseBody
	public List<OrderingDetailsVO> selectOrderingDeatilList(@RequestParam String orderingCode){
		return orderingService.selectOrderingDetailList(orderingCode);
	}
	
}
