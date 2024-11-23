package com.breadflow.app.prdtplan.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.prdtplan.service.PrdtplanService;
import com.breadflow.app.prdtplan.service.PrdtplanVO;

import jakarta.servlet.http.HttpSession;
//@RestController   <= 
@Controller
public class PrdtplanController {

	private PrdtplanService prdtplanService;
	public PrdtplanController(PrdtplanService prdtplanService) {
		this.prdtplanService = prdtplanService;
	}
	
	@GetMapping("prdtplanMng")
	public String prdtplanMng(Model model) {
		List<PrdtplanVO> list = prdtplanService.selectPrdtplanList();
		model.addAttribute("plans", list);
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
	
	@PostMapping("insertPrdtplanDetails.do")
	@ResponseBody
	public int insertPrdtplanDetails(PrdtplanVO prdtplanVO) {
		System.out.println("\n[PrdtplanController.java] insertPrdtplanDetails.do - prdtplanVO: " + prdtplanVO + "\n");
		return 1;
	}
}
