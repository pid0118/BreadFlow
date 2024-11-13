package com.breadflow.app.inout.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.OutstoreVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InOutController {
	private final InOutService inOutService;
	
//	@GetMapping("instoreList")
//	public String instoreList(Model model) {
//		List<InstoreVO> list = inOutService.instoreList();
//		model.addAttribute("instores", list);
//		return "inout/list";
//	}
//	
//	@GetMapping("outstoreList")
//	public String outstoreList(Model model) {
//		List<OutstoreVO> list = inOutService.outstoreList();
//		model.addAttribute("outstores", list);
//		return "inout/list";
//	}
	
	// 입고/출고 내역
    @GetMapping("inOutList")
    public String inOutList(Model model) {
        return "inout/list"; // 초기 페이지 로드
    }
    
    // 입고 내역을 반환 (AJAX)
    @GetMapping("inout/instores")
    @ResponseBody
    public List<InstoreVO> getInstoreList() {
        return inOutService.instoreList();
    }

    // 출고 내역을 반환 (AJAX)
    @GetMapping("inout/outstores")
    @ResponseBody
    public List<OutstoreVO> getOutstoreList() {
        return inOutService.outstoreList();
    }
	
//	@GetMapping("inOutList")
//	public String inOutList(Model model) {
//		List<InstoreVO> inList = inOutService.instoreList();
//		List<OutstoreVO> outList = inOutService.outstoreList();
//		model.addAttribute("instores", inList);
//		model.addAttribute("outstores", outList);
//		return "inout/list";
//	}
	
	@GetMapping("instoreInfo")
	public String instoreInfo(InstoreVO instoreVO, Model model) {
		InstoreVO findVO = inOutService.instoreInfo(instoreVO);
		model.addAttribute("instore", findVO);
		return "inout/info";
	}
	
	@GetMapping("outstoreInfo")
	public String outstoreInfo(OutstoreVO outstoreVO, Model model) {
		OutstoreVO findVO = inOutService.outstoreInfo(outstoreVO);
		model.addAttribute("outstore", findVO);
		return "inout/info";
	}
	
	@GetMapping("insertIn")	
	public String insertIn() {
		return "inout/insert";
	}
	
	@PostMapping("insertIn")
	public String insertInProcess(InstoreVO instoreVO) {
		int mno = inOutService.instoreInsert(instoreVO);
		String url = null;
		if(mno > 0) {
			url = "redirect:instoreList?memberNo=" + mno;
		} else {
			url = "redirect:insertIn";
		}
		return url;
	}
	
	@GetMapping("insertOut")	
	public String insertOut() {
		return "inout/insert";
	}
	
	@PostMapping("insertOut")
	public String insertOutProcess(OutstoreVO outstoreVO) {
		int mno = inOutService.outstoreInsert(outstoreVO);
		String url = null;
		if(mno > 0) {
			url = "redirect:outstoreList?memberNo=" + mno;
		} else {
			url = "redirect:insertOut";
		}
		return url;
	}
}
