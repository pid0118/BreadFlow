
package com.breadflow.app.inout.web;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

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
import com.breadflow.app.inout.service.OutstoreVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InOutController {
	private final InOutService inOutService;
	
    @GetMapping("inOutList")
    public String inOutList(Model model) {
    	Calendar cal = Calendar.getInstance();
    	Integer localDateTime = cal.get(Calendar.YEAR);
    	
    	List<ItemListVO> items = inOutService.itemList();
    	model.addAttribute("items", items);
    	model.addAttribute("localDateTime", localDateTime);
        return "inout/list";
    }
    
    // 입고 내역 반환
    @GetMapping("inOut/instores")
    @ResponseBody
    public Map<String, Object> getInstoreList(Map<String, Object> inMap, FilterVO filterVO) {
    	Integer countIn = inOutService.countInstore(filterVO);
    	inMap.put("count", countIn);
    	inMap.put("list", inOutService.instoreList(filterVO));
        return inMap;
    }
    
    // 출고 내역 반환
    @GetMapping("inOut/outstores")
    @ResponseBody
    public Map<String, Object> getOutstoreList(Map<String, Object> outMap, FilterVO filterVO) {
    	Integer countOut = inOutService.countOutstore(filterVO);
    	outMap.put("count", countOut);
    	outMap.put("list", inOutService.outstoreList(filterVO));
        return outMap;
    }
    
    // 등록용 발주 내역 반환
    @GetMapping("inOut/ordersInsert")
    @ResponseBody
    public Map<String, Object> getOrderListForInsert(Map<String, Object> orderMap, FilterVO filterVO) {
    	Integer countOr = inOutService.countOrderInsert(filterVO);
    	orderMap.put("count", countOr);
    	orderMap.put("list", inOutService.orderListForInsert(filterVO));
        return orderMap;
    }
    
    // 등록용 입고 내역 반환
    @GetMapping("inOut/instoresInsert")
    @ResponseBody
    public Map<String, Object> getInstoreListForInsert(Map<String, Object> inMap, FilterVO filterVO) {
    	Integer countIn = inOutService.countInstoreInsert(filterVO);
    	inMap.put("count", countIn);
    	inMap.put("list", inOutService.instoreListForInsert(filterVO));
        return inMap;
    }
	
    // 입출고 등록
	@GetMapping("inOutInsert")	
	public String inOutInsert(Model model) {
		List<ItemListVO> items = inOutService.itemList();
		model.addAttribute("items", items);
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