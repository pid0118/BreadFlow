package com.breadflow.app.product.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.breadflow.app.product.service.ProductService;
import com.breadflow.app.product.service.ProductVO;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	// 전체조회
	@GetMapping("productListAll")
	public String productListAll(Model model) {
		List<ProductVO> list = productService.getListAll();
		
		model.addAttribute("products", list);
		return "product/productListAll";
	}
	
	// 단건조회
	@GetMapping("productInfo")
	public String productInfo(ProductVO prductVO, Model model) {
		
		ProductVO findVO = productService.getInfo(prductVO);
		
		model.addAttribute("product", findVO);
		return "product/productInfo";
	}
	
	// 제품등록 - 페이지
	@GetMapping("productInsert")
	public String productInsertForm() {
		return "product/productInsert";
	}
	
	// 제품등록 - 처리
	@PostMapping("productInsert")
	public String productInsertProcess(ProductVO productVO) {
		return "product/productListAll";
	}
	
	
	
}
