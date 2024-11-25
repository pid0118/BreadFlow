package com.breadflow.app.prdtplan.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String insertPrdtplan(PrdtplanVO prdtplanVO, HttpSession session) {
		System.out.println("\n[PrdtplanController.java] insertPrdtplan.do - prdtplanVO: " + prdtplanVO + "\n");
		String writer = (String) session.getAttribute("memNo");
		
		if(writer == null || writer == "") {
			return "";
		}
		
		prdtplanVO.setWriter(writer);
		String result = prdtplanService.insertPrdtplan(prdtplanVO);
		
		System.out.println("\n[PrdtplanController.java] insertPrdtplan.do - result: " + result + "\n");
		return result;
	}
	
	@PostMapping("insertPrdtplanDetails.do")
	@ResponseBody
	public int insertPrdtplanDetails(@RequestBody List<PrdtplanVO> list) {
		System.out.println("\n[PrdtplanController.java] insertPrdtplanDetails.do - prdtplanVO: " + list + "\n");
		int result = prdtplanService.insertPrdtplanDetail(list);
		return result;
	}
	
	@GetMapping("selectPrdtplan")
	@ResponseBody
	public PrdtplanVO selectPrdtplan(@RequestParam String id) {
		System.out.println("\n[PrdtplanController.java] selectPrdtplan - productionPlanNo: " + id + "\n");
		PrdtplanVO prdtplanVO = new PrdtplanVO();
		prdtplanVO.setProductionPlanNo(id);
		
		
		PrdtplanVO pVO = prdtplanService.selectPrdtplan(prdtplanVO);
		System.out.println("\n[PrdtplanController.java] selectPrdtplan - PrdtplanVO: " + pVO + "\n");
		return pVO;
	}
}
