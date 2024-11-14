package com.breadflow.app.product.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.product.service.ProductService;
import com.breadflow.app.product.service.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	     
	// 전체조회
	@GetMapping("productListAll")                           
	public String productListAll(Model model) {
		List<ProductVO> list = productService.getListAll();
		
		model.addAttribute("products", list);
		return "product/prodctListAll";
	}
	
	// 단건조회
	@GetMapping("productInfo")
	public String productInfo(ProductVO prductVO, Model model) {
		
		ProductVO findVO = productService.getInfo(prductVO);
		
		model.addAttribute("product", findVO);
		return "product/productInfo";
	}
	
	// 제품등록 - 페이지
	@GetMapping("product/Insert")
	public String productInsertForm() {
		return "product/productInsert";
	}
	
	// 제품등록 - 처리
	@PostMapping("product/Insert")
	public String productInsertProcess(ProductVO productVO) {
		return "redirect:/productListAll";
	}
	
	
	
}
