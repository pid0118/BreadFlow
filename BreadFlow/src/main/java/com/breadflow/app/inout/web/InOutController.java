
package com.breadflow.app.inout.web;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.inout.service.FilterVO;
import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.ItemListVO;
import com.breadflow.app.inout.service.OrderListVO;
import com.breadflow.app.inout.service.OutstoreVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InOutController {
	private final InOutService inOutService;
	
	
	// 입출고 내역
    @GetMapping("inOutList")
    public String inOutList(Model model, HttpSession session) {
    	Calendar cal = Calendar.getInstance();
    	Integer localDateTime = cal.get(Calendar.YEAR);
    	List<ItemListVO> items = inOutService.itemList();
    	String companyName = (String) session.getAttribute("companyName");
    	model.addAttribute("localDateTime", localDateTime);
    	model.addAttribute("items", items);
    	model.addAttribute("companyName", companyName);
        return "inout/list";
    }
    
    // 입고 내역 반환
    @GetMapping("inOut/instores")
    @ResponseBody
    public List<InstoreVO> getInstoreList(FilterVO filterVO) {
        return inOutService.instoreList(filterVO);
    }
    
    // 출고 내역 반환
    @GetMapping("inOut/outstores")
    @ResponseBody
    public List<OutstoreVO> getOutstoreList(FilterVO filterVO) {
        return inOutService.outstoreList(filterVO);
    }
    
    // 등록용 발주 내역 반환
    @GetMapping("inOut/ordersInsert")
    @ResponseBody
    public List<OrderListVO> getOrderListForInsert(FilterVO filterVO) {
        return inOutService.orderListForInsert(filterVO);
    }
    
    // 등록용 입고 내역 반환
    @GetMapping("inOut/instoresInsert")
    @ResponseBody
    public List<InstoreVO> getInstoreListForInsert(FilterVO filterVO) {
        return inOutService.instoreListForInsert(filterVO);
    }
	
    // 입출고 등록
	@GetMapping("inOutInsert")	
	public String inOutInsert(Model model, HttpSession session) {
		List<ItemListVO> items = inOutService.itemList();
		String companyName = (String) session.getAttribute("companyName");
		model.addAttribute("items", items);
		model.addAttribute("companyName", companyName);
		return "inout/insert";
	}
	
	// 입고 등록 반환
	@PostMapping("inOut/insertIn")
	@ResponseBody
	public int insertIn(@RequestBody List<InstoreVO> instoreVO) {
		return inOutService.instoreInsert(instoreVO);
	}
	
	// 출고 등록 반환
	@PostMapping("inOut/insertOut")
	@ResponseBody
	public int insertOut(@RequestBody List<OutstoreVO> outstoreVO) {
		return inOutService.outstoreInsert(outstoreVO);
	}
}