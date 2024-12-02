package com.breadflow.app.bom.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.bom.service.BomService;
import com.breadflow.app.bom.service.BomVO;
import com.breadflow.app.common.service.CategoryService;
import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.ComCodeVO;
import com.breadflow.app.product.service.ProductService;
import com.breadflow.app.product.service.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BomController {
	private final BomService bomService;
	final CategoryService categoryService;
	final ProductService productService;
	
	// 전체조회
	@GetMapping("bomProductList")
	public String selectProductList(ProductVO productVO, Model model) {
		
		// 제품 리스트
		List<ProductVO> list = productService.selectProductList(productVO);
				
		// 카테고리
		List<CategoryVO> category = categoryService.selectCategorySub("제품");
				
		model.addAttribute("products", list);
		model.addAttribute("category", category);
		
		return "bom/bomProductList";
	}
<<<<<<< HEAD
	// bom상세보기 페이지
=======
	
	// BOM 조회
>>>>>>> branch 'indeukk' of https://github.com/pid0118/BreadFlow.git
	@GetMapping("bomCheck")
<<<<<<< HEAD
	public String selectBom(@RequestParam String productCode, Model model) {
		
		ProductVO product = productService.selectProduct(productCode);
		model.addAttribute("product", product);
=======
	public String selectProduct(@RequestParam String productCode, Model model) {
>>>>>>> branch 'indeukk' of https://github.com/pid0118/BreadFlow.git
		
		bomService.selectBom(productCode);
		
		return "bom/bomCheck";
	}
	
	// BOM 데이터 불러오기
	@GetMapping("bomChecks")
	@ResponseBody
	public List<BomVO> selectBomDetail(@RequestParam String productCode) {
		BomVO bomVO = new BomVO();
		bomVO.setProductCode(productCode);
		
		List<BomVO> list = bomService.selectBom(bomVO);
		return list;
	}
	
	
	// BOM 등록 페이지 이동
	@GetMapping("bomInsert")
	public String insertBom(@RequestParam String productCode, Model model){
		
		ProductVO product = productService.selectProduct(productCode);
		model.addAttribute("product", product);
		
		return "bom/bomInsert"; 
	}
	
	// bom 등록 처리
	@ResponseBody
	@PostMapping("bomInsert")
	public int insertBomProcess(@RequestBody List<BomVO> list) {
		int result = bomService.insertBom(list);
		return result;
	}
	
	
	//bom 수정 페이지
	@GetMapping("bomUpdate")
	public String updateBom(@RequestParam String productCode, Model model) {
		
		ProductVO product = productService.selectProduct(productCode);
		
		model.addAttribute("product", product);
		
		return "bom/bomUpdate";
	}
	
	
	// bom 수정 처리
	@ResponseBody
	@PostMapping("bomUpdate")
	public int updateBomProcess(@RequestBody List<BomVO> list) {
	  int result = bomService.updateBom(list);
		
	  return result;
	}
	
	
}
