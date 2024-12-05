package com.breadflow.app.product.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.account.service.AccountService;
import com.breadflow.app.account.service.AccountVO;
import com.breadflow.app.common.service.CategoryService;
import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.ComCodeService;
import com.breadflow.app.common.service.ComCodeVO;
import com.breadflow.app.product.service.ProductService;
import com.breadflow.app.product.service.ProductVO;

import lombok.RequiredArgsConstructor;


/**
 * 제품 관리
 * 작성자 : 박인득
 * 
 */
@Controller
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	private final ComCodeService comCodeService;
	private final AccountService accountService;
	     
	// 전체조회
	@GetMapping("productListAll")                           
	public String selectProductList(ProductVO productVO, AccountVO accountVO, Model model) {
		// 제품 리스트
		List<ProductVO> list = productService.selectProductList(productVO);
		
		// 카테고리
		List<CategoryVO> category = categoryService.selectCategorySub("제품");
		List<ComCodeVO> codeVal = comCodeService.selectComCode("0J");
		List<AccountVO> List = accountService.selectMemberList(accountVO);
		
		model.addAttribute("accounts", List);
		model.addAttribute("products", list);
		model.addAttribute("category", category);
		model.addAttribute("codeVal" , codeVal);
		
		return "product/prodctListAll";
	}
	
	
	
	// 제품등록 - 페이지
	@GetMapping("productInsert")
	public String productInsertForm(Model model) {
		
		String productCode = productService.selectProductCode();
		
		List<CategoryVO> category = categoryService.selectCategorySub("제품");
		List<ComCodeVO> codeVal = comCodeService.selectComCode("0J");
		
		model.addAttribute("productCode", productCode);
		
		model.addAttribute("category", category);
		model.addAttribute("codeVal", codeVal);
		
		return "product/productInsert";
	}
	
	
	// 상품명 중복체크
	@PostMapping("productNameCheck")
	@ResponseBody
	public ResponseEntity<Boolean> productNameCheck(String productName, String productCode) {
		 
		String productreuslt = productService.selectProductName(productName, productCode);
		
		if (productreuslt != null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	    }
	    return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	

	// 단건조회
	@ResponseBody
	@GetMapping("product/{productCode}")
	public ProductVO selectProduct(@PathVariable String productCode, Model model) {
		
		ProductVO productVO = productService.selectProduct(productCode);
		
		return productVO;
	}
	
	
	// 제품등록 - 처리
	@ResponseBody
	@PostMapping("product")
	public int productInsertProcess(@RequestBody ProductVO productVO) {
		
		int result = productService.insertProduct(productVO);
			
		return result;
	}

	
	// 수정처리
	@ResponseBody
	@PutMapping("product")
	public int productUpdateProcess(@RequestBody ProductVO productVO) {
		return productService.updateProductList(productVO);
	}
	
	
	// 삭제처리
	@DeleteMapping("product")
	@ResponseBody
	public int productDelete(@RequestBody List<String> checkBoxArr) {
		
		return productService.deleteProduct(checkBoxArr);
	}
	
}
