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

import jakarta.servlet.http.HttpSession;

@Controller
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	// 본사 가맹점 정보 / 매출 조회
    @GetMapping("/toSalList")
    public String totalSale(Model model) {
		List<SaleVO> list = saleService.selectSaleList();
		model.addAttribute("SList", list);
		return "sale/toSalList";
    }
    
    // POS 메인화면 및 상세내역 모달창
    @GetMapping("/pos")
    public String posPage(Model model, HttpSession name) {
    	List<PosVO> list = saleService.selectDetailSale(name);
    	model.addAttribute("dList", list);
        return "sale/pos"; // pos.html을 반환
    }

	// POS 카테고리 검색(AJAX) - 다른 URL 사용
    @ResponseBody
    @PostMapping("/pos/menu")					  // 파라미터를 매개변수로 받음(category 매개변수를 선택안해도 응답함)
    public ResponseEntity<List<ProductVO>> getMenu(@RequestParam(required = false) String category) {
        List<ProductVO> products = saleService.selectProductList(category);
        
        return ResponseEntity.ok(products);  // 정상적으로 JSON 응답 반환 (요청에 성공적으로 응답)
    }

    // 주문 버튼 눌렀을시 insert
    @PostMapping("/pos")
    @ResponseBody
    public String insertSale(@RequestBody List<PosVO> posVO) {
    		saleService.insertSale(posVO);
    	return "true";
    }
    
    // 가맹점 매출 조회
    @GetMapping("/daySale")
    public String daySale() {
		return "sale/daySale";
    }
    
    // 매출조회 데이터 (월 조건)
    @PostMapping("/daySale")
    @ResponseBody
    public ResponseEntity<List<PosVO>> daySaleAjax(@RequestParam(required = false) String saDate, HttpSession companyNo) {
    	List<PosVO> list = saleService.selectSales(saDate, companyNo);
    	return ResponseEntity.ok(list);
    }
    
    // 마감정산
    @PostMapping("/closeSale")
    @ResponseBody
    public String closeSale(@RequestBody PosVO name) {
    	saleService.insertSales(name);
        return "sale/pos";
    }
    
    // 매출 차트 조회 (가맹점) << 일,월매출 / 제품별 상세매출 그래프 표시
    @GetMapping("/saleChart")
    public String saleChart() {
    	return "sale/chart";
    }
    
    // 차트 월별 매출 ajax호출
    @PostMapping("/saleChart")
    @ResponseBody
    public ResponseEntity<List<PosVO>> saleChartList(HttpSession name) {
    	List<PosVO> list = saleService.selectSaleChart(name);
    	return ResponseEntity.ok(list);
    }
    // 차트 월별 제품 상세 매출 ajax호출
    @PostMapping("/saleChart/product")
    @ResponseBody
    public ResponseEntity<List<PosVO>> saleProductList(HttpSession name) {
    	List<PosVO> list = saleService.selectSaleProduct(name);
    	return ResponseEntity.ok(list);
    }
}
