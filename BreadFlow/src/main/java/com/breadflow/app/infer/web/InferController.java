package com.breadflow.app.infer.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.breadflow.app.infer.service.InferService;
import com.breadflow.app.inout.service.FilterVO;
import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.InstoreVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InferController {
	private final InferService inferService;
	private final InOutService inOutService;
	
	// 불량 내역 조회
	@GetMapping("inferList")
	public String inferList(Model model) {
		Calendar cal = Calendar.getInstance();
		List<CompanyVO> companyList = inferService.companyList();
    	Integer localDateTime = cal.get(Calendar.YEAR);
    	model.addAttribute("companyList", companyList);
    	model.addAttribute("localDateTime", localDateTime);
        return "infer/list";
	}
	
	// 불량 내역 반환
	@GetMapping("infer/getInferList")
	@ResponseBody
	public Map<String, Object> getInferList(FilterVO filterVO) {
		Map<String, Object> inferMap = new HashMap<String, Object>();
		Integer countInfer = inferService.inferListCount(filterVO);
		inferMap.put("count", countInfer);
		inferMap.put("list", inferService.inferList(filterVO));
		return inferMap;
	}
	
	// 불량 내역 상세 조회
	@GetMapping("inferDetailAnswer/{inferNo}")
	public String inferDetailAnswer(@PathVariable String inferNo, Model model) {
		List<InferDetailVO> list = inferService.inferListDetail(inferNo);
		InferAnswerVO answer = inferService.inferAnswerDetail(inferNo);
		model.addAttribute("inferNo", inferNo);
		model.addAttribute("infer", list);
		model.addAttribute("answer", answer);
		return "infer/inferDetailAnswer";
	}
	
	// 불량 내역 상세 조회
	@GetMapping("inferDetailList/{inferNo}")
	public String inferDetailList(@PathVariable String inferNo, Model model) {
		List<InferDetailVO> list = inferService.inferListDetail(inferNo);
		model.addAttribute("inferNo", inferNo);
		model.addAttribute("infer", list);
		return "infer/inferDetailList";
	}
	
	// 불량 내역 등록
	@GetMapping("inferInsert")
	public String inferInsert(Model model, HttpSession session) {
		return "infer/insert";
	}
	
	// 불량 내역 등록용 입고 내역 반환
	@GetMapping("infer/getInstore")
	@ResponseBody
	public List<InstoreVO> getInstoreList(FilterVO filterVO) {
        return inOutService.instoreList(filterVO);
    }
	
	// 불량 상세 내역 등록 반환
	@PostMapping("infer/insertInfer")
	@ResponseBody
	public int insertInfer(@RequestBody List<InferDetailVO> inferDetailVO) {
		return inferService.inferInsert(inferDetailVO);
	}
	
	// 불량 답변 등록
	@GetMapping("inferAnswerInsert/{inferNo}")
	public String inferAnswerInsert(@PathVariable String inferNo, Model model) {
		List<InferDetailVO> list = inferService.inferListDetail(inferNo);
		model.addAttribute("inferNo", inferNo);
		model.addAttribute("infer", list);
		return "infer/answer";
	}
	
	// 불량 답변 등록 반환
	@PostMapping("infer/insertInferAnswer")
	@ResponseBody
	public int insertInferAnswer(@RequestBody InferAnswerVO inferAnswerVO) {
		return inferService.inferAnswerInsert(inferAnswerVO);
	}

}
