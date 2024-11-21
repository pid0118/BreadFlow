package com.breadflow.app.ordering.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.breadflow.app.ordering.service.OrderingDetailVO;
import com.breadflow.app.ordering.service.OrderingService;
import com.breadflow.app.ordering.service.OrderingVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderingController {
	private final OrderingService orderingService;
	
	@GetMapping("ordering/insert")
	public String insertForm() {
		return "ordering/insert";
	}
	
	@PostMapping("ordering/insert")
	public String insertOrdering(@RequestBody Map<String, Object> ordering) {
		int result = orderingService.insertOrdering(ordering);
		return "ordering/insert";
	}
}
