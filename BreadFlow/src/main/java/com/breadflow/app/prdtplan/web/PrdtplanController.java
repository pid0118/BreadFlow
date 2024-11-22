package com.breadflow.app.prdtplan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.prdtplan.service.PrdtplanService;
import com.breadflow.app.prdtplan.service.PrdtplanVO;

import jakarta.servlet.http.HttpSession;

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
	public int insertPrdtplan(PrdtplanVO prdtplanVO, HttpSession session) {
		System.out.println("\n[PrdtplanController.java] insertPrdtplan.do - prdtplanVO: " + prdtplanVO + "\n");
		String writer = (String) session.getAttribute("memNo");
		
		if(writer == "" || writer == null) {
			return 0;
		}
		
		prdtplanVO.setWriter(writer);
		int result = prdtplanService.insertPrdtplan(prdtplanVO);
		
		System.out.println("\n[PrdtplanController.java] insertPrdtplan.do - result: " + result + "\n");
		return result;
	}
}
