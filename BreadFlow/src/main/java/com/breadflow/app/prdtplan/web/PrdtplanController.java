package com.breadflow.app.prdtplan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.breadflow.app.prdtplan.service.PrdtplanService;

@Controller
public class PrdtplanController {

	private PrdtplanService prdtplanService;
	public PrdtplanController(PrdtplanService prdtplanService) {
		this.prdtplanService = prdtplanService;
	}
	
	@GetMapping("prdtplanMng")
	public String prdtplanMng() {
		return "prdtplan/prdtplanMng";
	}
}
