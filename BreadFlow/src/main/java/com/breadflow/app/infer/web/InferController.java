package com.breadflow.app.infer.web;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.infer.service.CompanyVO;
import com.breadflow.app.infer.service.InferAnswerVO;
import com.breadflow.app.infer.service.InferDetailVO;
import com.breadflow.app.infer.service.InferHistoryVO;
import com.breadflow.app.infer.service.InferService;
import com.breadflow.app.inout.service.FilterVO;
import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.ItemListVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InferController {
	private final InferService inferService;
	private final InOutService inOutService;
	
	// 불량 내역 조회
	@GetMapping("inferList")
	public String inferList(Model model, HttpSession session) {
		Calendar cal = Calendar.getInstance();
		List<CompanyVO> companyList = inferService.companyList();
    	Integer localDateTime = cal.get(Calendar.YEAR);
    	String companyName = (String) session.getAttribute("companyName");
    	model.addAttribute("companyList", companyList);
    	model.addAttribute("localDateTime", localDateTime);
    	model.addAttribute("companyName", companyName);
        return "infer/list";
	}
	
	// 불량 내역 반환
	@GetMapping("infer/getInferList")
	@ResponseBody
	public List<InferHistoryVO> getInferList(FilterVO filterVO) {
		return inferService.inferList(filterVO);
	}
	
	// 불량 내역 상세 조회
	@GetMapping("inferListDetail/{inferNo}")
	public String inferListDetail(@PathVariable String inferNo, Model model) {
		List<InferDetailVO> list = inferService.inferListDetail(inferNo);
		model.addAttribute("infers", list);
		return "infer/detail";
	}
	
	// 불량 내역 등록
	@GetMapping("inferInsert")
	public String inferInsert(Model model) {
		List<ItemListVO> items = inOutService.itemList();
		model.addAttribute("items", items);
		return "infer/insert";
	}
	
	// 불량 상세 내역 등록 반환
	@PostMapping("infer/insertInferDetail")
	@ResponseBody
	public int insertInfer(@RequestBody List<InferDetailVO> inferDetailVO) {
		return inferService.inferInsert(inferDetailVO);
	}
	
	// 불량 내역 등록 반환
	@PostMapping("infer/insertInferHistory")
	@ResponseBody
	public int insertInferHistory(@RequestBody InferHistoryVO inferHistoryVO) {
		return inferService.inferHistoryInsert(inferHistoryVO);
	}
	
	// 불량 답변 등록
	@GetMapping("inferAnswerInsert/{inferNo}")
	public String inferAnswerInsert(@PathVariable String inferNo, Model model, HttpSession session) {
		List<InferDetailVO> list = inferService.inferListDetail(inferNo);
		String loginMember = (String) session.getAttribute("name");
		model.addAttribute("infer", list);
		model.addAttribute("loginMember", loginMember);
		model.addAttribute("inferNo", inferNo);
		return "infer/answer";
	}
	
	// 불량 답변 등록 반환
	@PostMapping("infer/insertInferAnswer")
	@ResponseBody
	public int insertInferAnswer(@RequestBody InferAnswerVO inferAnswerVO) {
		int result = 0;
		result = inferService.inferUpdate(inferAnswerVO);
		result = inferService.inferAnswerInsert(inferAnswerVO);
		return result;
	}
}
