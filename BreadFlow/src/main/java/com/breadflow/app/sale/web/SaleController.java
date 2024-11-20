package com.breadflow.app.sale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.product.service.ProductVO;
import com.breadflow.app.sale.service.PosVO;
import com.breadflow.app.sale.service.SaleService;
import com.breadflow.app.sale.service.SaleVO;
@Controller
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	// 본사 가맹점 정보 / 매출 조회
    @GetMapping("/toSalList")
    public String totalSale(Model model) {
		List<PosVO> list = saleService.selectSaleList();
		model.addAttribute("SList", list);
		return "sale/toSalList";
    }
    
    // POS 메인화면
    @GetMapping("/pos")
    public String posPage() {
        return "sale/pos"; // pos.html을 반환
    }

	// POS 카테고리 검색(AJAX) - 다른 URL 사용
    
    @ResponseBody
    @GetMapping("/pos/menu")
    public ResponseEntity<List<ProductVO>> getMenu(@RequestParam(required = false) String category) {
        List<ProductVO> products = saleService.selectProductList(category);
        
        return ResponseEntity.ok(products);  // 정상적으로 JSON 응답 반환
    }

    // 주문 버튼 눌렀을시 insert
    @PostMapping("/insertSale")
    @ResponseBody
    public String insertSale(@RequestParam List<SaleVO> saleVO) {
    		saleService.insertSale(saleVO);
    	return "sale/pos";
    }

    
    
}
