package com.breadflow.app.sale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return "sale/toSalList";
    }
    
    @PostMapping("/getOffice")
    @ResponseBody
    public List<SaleVO> saleAjaxList(){
    	return saleService.selectSaleList();
    }
    
    // 월별 매출조회
    @PostMapping("/toSalList/Month")
    @ResponseBody
    public List<SaleVO> saleListOffice(@RequestParam String comNo){
    	List<SaleVO> list = saleService.selectSaleOffice(comNo);
    	return list;
    }
    // 일별 매출조회
    @PostMapping("/toSalList/days")
    @ResponseBody
    public List<SaleVO> saleListDetailOffice(@RequestParam String comNo, @RequestParam String saleDate){
    	List<SaleVO> list = saleService.selectSaleDetailOffice(comNo, saleDate);
    	return list;
    }
    
    
    // POS 메인화면
    @GetMapping("/pos")
    public String posPage() {
        return "sale/pos";
    }
    
    // Pos 상세내역 모달창
    @PostMapping("/getSalesDetails")
    @ResponseBody
    public List<PosVO> getSalesDetails(HttpSession name){
    	return saleService.selectDetailSale(name);
    }

	// POS 카테고리 검색(AJAX) - 다른 URL 사용
    @ResponseBody
    @PostMapping("/pos/menu")					  // 파라미터를 매개변수로 받음(category 매개변수를 선택안해도 응답함)
    public List<ProductVO> getMenu(@RequestParam(required = false) String category) {
        List<ProductVO> products = saleService.selectProductList(category);
        
        return products;  // 정상적으로 JSON 응답 반환 (요청에 성공적으로 응답)
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
    public List<PosVO> daySaleAjax(@RequestParam(required = false) String saDate, HttpSession companyNo) {
    	List<PosVO> list = saleService.selectSales(saDate, companyNo);
    	return list;
    }
    
    // 마감정산
    @PostMapping("/closeSale")
    @ResponseBody
    public String closeSale(HttpSession name) {
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
    public List<PosVO> saleChartList(HttpSession companyNo) {
    	List<PosVO> list = saleService.selectSaleChart(companyNo);
    	return list;
    }
    
    // 차트 월별 제품 상세 매출 ajax호출
    @PostMapping("/saleChart/product")
    @ResponseBody
    public List<PosVO> saleProductList(HttpSession companyNo) {
    	List<PosVO> list = saleService.selectSaleProduct(companyNo);
    	return list;
    }
}
