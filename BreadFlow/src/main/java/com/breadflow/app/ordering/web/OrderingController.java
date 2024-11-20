package com.breadflow.app.ordering.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderingController {
	@GetMapping("ordering/insert")
	public String insertForm() {
		return "ordering/insert";
	}
	
	@PostMapping("ordering/insert")
	public String insertOrdering() {
		return "redirect:";
	}
}
