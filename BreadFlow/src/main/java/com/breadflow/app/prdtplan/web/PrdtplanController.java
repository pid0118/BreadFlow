package com.breadflow.app.prdtplan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("insertPrdtplan.do")
	@ResponseBody
	public int insertPrdtplan() {
		return 1;
	}
}
