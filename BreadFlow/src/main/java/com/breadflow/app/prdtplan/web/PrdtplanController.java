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
	
	@GetMapping("selectPrdtplanDetail")
	@ResponseBody
	public List<PrdtplanVO> selectPrdtplanDetail(@RequestParam String id) {
		PrdtplanVO prdtplanVO = new PrdtplanVO();
		prdtplanVO.setProductionPlanNo(id);
		
		List<PrdtplanVO> list = prdtplanService.selectPrdtplanDetailList(prdtplanVO);
		return list;
	}
	
	@PostMapping("updateDetailForProgress")
	@ResponseBody
	public int updatedetailForProgress(@RequestBody PrdtplanVO prdtplanVO) {
		System.out.println("\n[PrdtplanController.java] updatedetailForProgress - PrdtplanVO: " + prdtplanVO + "\n");
		int result = prdtplanService.updatedetailForProgress(prdtplanVO);
		return result;
	}

	
	@GetMapping("getProducts")
	@ResponseBody
	public List<PrdtplanVO> selectProductList(Model model) {
		List<PrdtplanVO> list = prdtplanService.selectPrdtList();
		model.addAttribute("products", list);
		return list;
	}
	
	
	//== 생산관리계획(제조공장) 페이지에서 사용되는 컨트롤러 ==//
	
	@GetMapping("prdtplanPrcs")
	public String prdtplanPrcs(Model model, HttpSession session) {
		String CompanyNo = (String) session.getAttribute("companyNo");
		List<PrdtplanVO> list = prdtplanService.selectPrdtplanListForCom(CompanyNo);
		System.out.println("\n[PrdtplanController.java] prdtplanPrcs - CompanyNo: " + CompanyNo + "\n");
		model.addAttribute("plans", list);
		return "prdtplan/prdtplanPrcs";
	}
	
	@PostMapping("updateDetailForProgressToC4")
	@ResponseBody
	public int updateDetailForProgressToC4(@RequestBody PrdtplanVO prdtplanVO) {
		System.out.println("\n[PrdtplanController.java] updatedetailForProgress - PrdtplanVO: " + prdtplanVO + "\n");
		int result = prdtplanService.updateDetailForProgressToC4(prdtplanVO);
		return result;
	}
	
	@PostMapping("updateDetailForProgressToC5")
	@ResponseBody
	public int updateDetailForProgressToC5(@RequestBody PrdtplanVO prdtplanVO) {
		System.out.println("\n[PrdtplanController.java] updatedetailForProgress - PrdtplanVO: " + prdtplanVO + "\n");
		int result = prdtplanService.updateDetailForProgressToC5(prdtplanVO);
		int result2 = prdtplanService.insertInstoreForPrdtplan(prdtplanVO);
		return result + result2;
	}
	
	@PostMapping("insertPrdtplanDetailsForSelf")
	@ResponseBody
	public int insertPrdtplanDetailsForSelf(@RequestBody List<PrdtplanVO> list) {
		System.out.println("\n[PrdtplanController.java] insertPrdtplanDetails.do - prdtplanVO: " + list + "\n");
		int result = prdtplanService.insertPrdtplanDetailsForSelf(list);
		return result;
	}

}
