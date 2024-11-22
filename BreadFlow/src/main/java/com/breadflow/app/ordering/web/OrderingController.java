package com.breadflow.app.ordering.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.ordering.service.OrderingDetailVO;
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
	public List<OrderingVO> selectOrderList(){
		List<OrderingVO> list = orderingService.selectOrderingList();
		return list;
	}
	
}
