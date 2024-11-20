
package com.breadflow.app.inout.web;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.ItemListVO;
import com.breadflow.app.inout.service.OrderListVO;
import com.breadflow.app.inout.service.OutstoreVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InOutController {
	private final InOutService inOutService;
	
	// 입고/출고 내역
    @GetMapping("inOutList")
    public String inOutList(Model model) {
    	Calendar cal = Calendar.getInstance();
    	Integer localDateTime = cal.get(Calendar.YEAR);
    	List<ItemListVO> items = inOutService.itemList();
    	model.addAttribute("localDateTime", localDateTime);
    	model.addAttribute("items", items);
        return "inout/list"; // 초기 페이지 로드
    }
    
    // 입고 내역 반환 (AJAX)
    @GetMapping("inOut/instores")
    @ResponseBody
    public List<InstoreVO> getInstoreList() {
        return inOutService.instoreList();
    }
    
    // 출고 내역 반환 (AJAX)
    @GetMapping("inOut/outstores")
    @ResponseBody
    public List<OutstoreVO> getOutstoreList() {
        return inOutService.outstoreList();
    }
    
    // 등록용 발주 내역 반환 (AJAX)
    @GetMapping("inOut/ordersInsert")
    @ResponseBody
    public List<OrderListVO> getOrderListForInsert() {
        return inOutService.orderListForInsert();
    }
    
    // 등록용 입고 내역 반환 (AJAX)
    @GetMapping("inOut/instoresInsert")
    @ResponseBody
    public List<InstoreVO> getInstoreListForInsert() {
        return inOutService.instoreListForInsert();
    }
	
    // 입고/출고 등록
	@GetMapping("inOutInsert")	
	public String inOutInsert(Model model) {
		List<ItemListVO> items = inOutService.itemList();
		model.addAttribute("items", items);
		return "inout/insert";
	}
	
	// 입고 등록 반환 (AJAX)
	@PostMapping("inOut/insertIn")
	@ResponseBody
	public int insertIn(@RequestBody List<InstoreVO> instoreVO) {
		System.out.println(instoreVO);
		return inOutService.instoreInsert(instoreVO);
	}
	
	// 출고 등록 반환 (AJAX)
	@PostMapping("inOut/insertOut")
	@ResponseBody
	public int insertOut(@RequestBody List<OutstoreVO> outstoreVO) {
		System.out.println(outstoreVO);
		return inOutService.outstoreInsert(outstoreVO);
	}
	
//	// 입고 등록 반환 (AJAX)
//	@PostMapping("inOut/insertIn")
//	@ResponseBody
//	public String insertInProcess(InstoreVO instoreVO) {
//		int mno = inOutService.instoreInsert(instoreVO);
//		String url = null;
//		if(mno > 0) {
//			url = "redirect:instoreList?memberNo=" + mno;
//		} else {
//			url = "redirect:insertIn";
//		}
//		return url;
//	}
//	
//	// 출고 등록 반환 (AJAX)
//	@PostMapping("inOut/insertOut")
//	@ResponseBody
//	public String insertOutProcess(OutstoreVO outstoreVO) {
//		int mno = inOutService.outstoreInsert(outstoreVO);
//		String url = null;
//		if(mno > 0) {
//			url = "redirect:outstoreList?memberNo=" + mno;
//		} else {
//			url = "redirect:insertOut";
//		}
//		return url;
//	}
}