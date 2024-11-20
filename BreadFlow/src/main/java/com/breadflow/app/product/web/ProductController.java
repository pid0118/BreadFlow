package com.breadflow.app.product.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.common.service.CategoryService;
import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.ComCodeService;
import com.breadflow.app.common.service.ComCodeVO;
import com.breadflow.app.product.service.ProductService;
import com.breadflow.app.product.service.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	final CategoryService categoryService;
	final ComCodeService comCodeService;
	     
	// 전체조회
	@GetMapping("productListAll")                           
	public String productListAll(ProductVO productVO, Model model) {
		// 제품 리스트
		List<ProductVO> list = productService.getListAll(productVO);
		
		// 카테고리
		List<CategoryVO> category = categoryService.getCategoriesSub("제품");
		
		model.addAttribute("products", list);
		model.addAttribute("category", category);
		
		return "product/prodctListAll";
	}
	
	
	
	// 단건조회
	@ResponseBody
	@GetMapping("productListAll/{productCode}")
	public ProductVO productInfo(@PathVariable String productCode, Model model) {
		
		ProductVO productVO = productService.getInfo(productCode);
		
		return productVO;
	}
	
	// 제품등록 - 페이지
	@GetMapping("product/Insert")
	public String productInsertForm(Model model) {
		
		String productCode = productService.getProductCode();
		List<CategoryVO> category = categoryService.getCategoriesSub("제품");
		List<ComCodeVO> codeVal = comCodeService.selectComCode("0J");
		
		model.addAttribute("productCode", productCode);
		model.addAttribute("category", category);
		model.addAttribute("codeVal", codeVal);
		
		return "product/productInsert";
	}
	
	// 제품등록 - 처리
	@ResponseBody
	@PostMapping("product/Insert")
	public int productInsertProcess(@RequestBody ProductVO productVO) {
		
		int result = productService.insertProduct(productVO);
			
		return result;
	}
	
	//수정 페이지
	@GetMapping("product/update")
	public String productUpdateForm() {
		return "product/productInsert";
	}
	
	// 수정처리
	@PostMapping("product/update")
	public String productUpdateProcess(ProductVO productVO) {
		
		return "redirect:/productListAll";
	}
	
	
	// 삭제처리
	@DeleteMapping("product/Delete")
	public String productDelete(ProductVO productVO) {
		
		
		return "redirect:/productListAll";
	}
	
}
