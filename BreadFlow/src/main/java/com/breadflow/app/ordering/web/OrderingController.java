package com.breadflow.app.ordering.web;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.ordering.service.OrderingService;
import com.breadflow.app.ordering.service.OrderingVO;

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
	public Map<String, Object> selectOrderList(@Param("status") String status, @Param("sort") String sort, @Param("page") int page){
		Map<String, Object> map = orderingService.selectOrderingList(status, sort, page);
		return map;
	}
	
	@PostMapping("/ordering/updateOdCancel")
	@ResponseBody
	public String updateOrdering(@Param("no") String no, @Param("reason") String reason) {
		orderingService.updateOrderingApprovalCancel(no, reason);
		return "";
	}
}
