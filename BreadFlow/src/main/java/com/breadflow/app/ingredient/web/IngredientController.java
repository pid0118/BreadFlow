package com.breadflow.app.ingredient.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.common.service.CategoryService;
import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.ComCodeService;
import com.breadflow.app.common.service.ComCodeVO;
import com.breadflow.app.ingredient.service.IngredientService;
import com.breadflow.app.ingredient.service.IngredientVO;
import com.breadflow.app.product.service.ProductVO;

import lombok.RequiredArgsConstructor;

/**
 * 원/부재료 관리
 * 작성자 : 박인득
 * 
 */

@Controller
@RequiredArgsConstructor
public class IngredientController {
	private final IngredientService ingredientService;
	private final CategoryService categoryService;
	private final ComCodeService comCodeService;
	
	// 전체 조회
	@GetMapping("inredientList")
	public String selectIngredientList(IngredientVO ingredientVO, Model model) {
		// 제품 리스트
		List<IngredientVO> list = ingredientService.selectIngredientList(ingredientVO);
				
		// 카테고리
		List<CategoryVO> category = categoryService.selectCategorySub("재료");
				
		model.addAttribute("ingredients", list);
		model.addAttribute("category", category);
				
		
		return "ingredient/ingredientList";
	}
	
	// 단건 조회
	@ResponseBody
	@GetMapping("ingredient/{ingredientCode}")
	public IngredientVO selectProduct(@PathVariable String ingredientCode, Model model) {
		
		IngredientVO ingredientVO = ingredientService.selectIngredient(ingredientCode);
		
		return ingredientVO;
	}
	
	// 원/부재료 등록 페이지
	@GetMapping("ingredientInsert")
	public String ingredientInsertForm(Model model) {
		
		String ingredientCode  = ingredientService.selectIngredientCode();
		
		List<CategoryVO> category = categoryService.selectCategorySub("재료");
		List<ComCodeVO> codeVal = comCodeService.selectComCode("0J");
		
		model.addAttribute("ingredientCode", ingredientCode);
		
		model.addAttribute("category", category);
		model.addAttribute("codeVal", codeVal);
		
		return "ingredient/ingredientInsert";
	}
	
	// 원/부재료 수정/삭제(공용사용) 페이지

	

	// 상품명 중복체크
	@PostMapping("ingredientNameCheck")
	@ResponseBody
	public ResponseEntity<Boolean> ingredientNameCheck(String ingredientName, String ingredientCode) {
		 
		String ingredientreuslt = ingredientService.selectIngredientName(ingredientName, ingredientCode);
		
		if (ingredientreuslt != null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	    }
	    return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	// 원/부재료 등록 처리
	@ResponseBody
	@PostMapping("ingredient")
	public int ingredientInsertProcess(@RequestBody IngredientVO ingredientVO) {
		
		int result = ingredientService.insertIngredient(ingredientVO);
			
		return result;
	}
	
	
	// 수정 기능처리
	
	
	// 삭제 기능처리
	
	
	
}
