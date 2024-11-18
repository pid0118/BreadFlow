package com.breadflow.app.sale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String posPage(Model model) {
        // '전체' 메뉴를 조회하여 첫 화면에 렌더링
        List<ProductVO> list = saleService.getListAll();
        model.addAttribute("product", list);
        return "sale/pos"; // pos.html을 반환
    }

    // POS 카테고리 검색(AJAX) - 다른 URL 사용
    @ResponseBody
    @GetMapping("/pos/menu")
    public List<ProductVO> getMenu(@RequestParam(defaultValue = "전체메뉴") String category) {
        // 'category' 파라미터를 기준으로 메뉴를 반환
        return saleService.getInfo(category);
    }


    
    
}
