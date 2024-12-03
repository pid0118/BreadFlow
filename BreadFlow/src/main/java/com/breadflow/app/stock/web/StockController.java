package com.breadflow.app.stock.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.stock.service.StockService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StockController {
	private final StockService stockService;
	
	// 재고 관리 페이지
	@GetMapping("/stock/list")
	public String stocklist() {
		return "stock/stocklist";
	}
	
	// 재고 관리 조회
	@GetMapping("/stock/stocklist")
	@ResponseBody
	public Map<String, Object> stockSelectList(@RequestParam (name = "facilities", defaultValue = "물류창고,제조공장,가맹점") String facilities,
											   @RequestParam (name = "major", defaultValue = "원재료,부재료,생산품,완제품") String major,
											   @RequestParam (name = "item", defaultValue = "") String item,
											   HttpSession session) {
		return stockService.selectStockList(facilities, major, item, session);
	}
	
	// 재고 상세 조회
	@GetMapping("/stock/detailList")
	@ResponseBody
	public Map<String, Object> stockSelectDetailList(@RequestParam String facilities,
													 @RequestParam String itemCode,
													 HttpSession session){
		return stockService.selectDetailStockList(facilities, itemCode, session);
	}

}
