package com.breadflow.app.bom.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// BOM 조회
	@ResponseBody
	@GetMapping("bomCheck")
	public BomVO selectProduct(BomVO bomVO) {
		
		
		return bomService.selectBom(bomVO);
	}
	
	// BOM 등록
	@GetMapping("bomInsert")
	public String insertBom(BomVO bomVO){
		
		return "bom/bomInsert"; 
	}
	
	
	
}