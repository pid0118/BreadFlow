package com.breadflow.app.sale.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.product.service.ProductVO;
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
    
    // POS 메인화면
    @GetMapping("/pos")
    public String posPage() {
        // '전체' 메뉴를 조회하여 첫 화면에 렌더링
		
		
        return "sale/pos"; // pos.html을 반환
    }

	// POS 카테고리 검색(AJAX) - 다른 URL 사용
    @ResponseBody
    @GetMapping("/pos/menu")
    public ResponseEntity<List<ProductVO>> getMenu(@RequestParam(required = false) String category) {
        List<ProductVO> products = saleService.getInfo(category);
        
        // 카테고리가 없다면 빈 목록을 반환하거나 오류를 처리
        if (products == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        return ResponseEntity.ok(products);  // 정상적으로 JSON 응답 반환
    }

    
    
    // 주문 버튼 눌렀을시 insert

    
    
}
