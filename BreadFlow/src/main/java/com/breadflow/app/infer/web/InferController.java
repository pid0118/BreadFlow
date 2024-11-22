package com.breadflow.app.infer.web;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.infer.service.InferAnswerVO;
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
    	Integer localDateTime = cal.get(Calendar.YEAR);
    	String companyName = (String) session.getAttribute("companyName");
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
	@GetMapping("inferListDetail")
	public String inferListDetail() {
		return "infer/detail";
	}
	
	// 불량 내역 등록
	@GetMapping("inferInsert")
	public String inferInsert(Model model) {
		List<ItemListVO> items = inOutService.itemList();
		model.addAttribute("items", items);
		return "infer/insert";
	}
	
	// 불량 내역 등록 반환
	@PostMapping("infer/insertInfer")
	@ResponseBody
	public int insertInfer(@RequestBody List<InferHistoryVO> inferHistoryVO) {
		return inferService.inferInsert(inferHistoryVO);
	}
	
	// 불량 답변 등록
	@GetMapping("inferAnswerInsert")
	public String inferAnswerInsert(Model model) {
		return "infer/answer";
	}
	
	// 불량 답변 등록 반환
	@PostMapping("infer/insertInferAnswer")
	@ResponseBody
	public int insertInferAnswer(@RequestBody List<InferAnswerVO> inferAnswerVO) {
		return inferService.inferAnswerInsert(inferAnswerVO);
	}
	
	// 불량 답변 확인 반환
	@PutMapping("infer/inferHistoryUpdate")
	@ResponseBody
	public int inferHistoryUpdate(@RequestBody List<InferHistoryVO> inferHistoryVO) {
		return inferService.inferUpdate(inferHistoryVO);
	}
}