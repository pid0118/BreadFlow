package com.breadflow.app.sale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.breadflow.app.sale.service.SaleService;
import com.breadflow.app.sale.service.SaleVO;
@Controller
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	// 본사 가맹점 정보 / 매출 조회
    @GetMapping("/toSalList")
    public String totalSale(Model model) {
		List<SaleVO> list = saleService.toGetList();
		model.addAttribute("SList", list);
		return "sale/toSalList";
    }
    
    //POS 메인화면
    @GetMapping("/pos")
    public String posSale() {
    	return "sale/pos";
    }
}
