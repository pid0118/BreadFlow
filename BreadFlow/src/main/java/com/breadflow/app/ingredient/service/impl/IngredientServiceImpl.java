package com.breadflow.app.ingredient.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.ingredient.mapper.IngredientMapper;
import com.breadflow.app.ingredient.service.IngredientService;
import com.breadflow.app.ingredient.service.IngredientVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService{
	private final IngredientMapper ingredientMapper;
	
	// 원부재료 전체조회
	@Override
	public List<IngredientVO> selectIngredientList(IngredientVO ingredientVO) {
		
		return ingredientMapper.selectIngredientList(ingredientVO);
	}
	
	// 원부재료 단건조회
	@Override
	public IngredientVO selectIngredient(String ingredientCode) {
		
		return ingredientMapper.selectIngredient(ingredientCode);
	}
	
	// 원부재료 등록
	@Override
	public int insertIngredient(IngredientVO ingredientVO) {
		
		return ingredientMapper.insertIngredient(ingredientVO);
	}
	
	
	//원부재료 수정
	@Override
	public int updateIngredient(IngredientVO ingredientVO) {
		
		return ingredientMapper.updateIngredient(ingredientVO);
	}
	
	// 원부재료 삭제
	@Transactional
	@Override
	public int deleteIngredient(List<String> ingredientCode) {
		
		int orderCount = ingredientMapper.selectOrderingIngredientCnt(ingredientCode);
	    int bomCount = ingredientMapper.selectBomIngredientCnt(ingredientCode);

	    if (orderCount > 0 || bomCount > 0) {
	        // 주문 중이거나 BOM에 등록된 재료가 있으면 삭제 중단
	        return -1;
	    }

	    for (String code : ingredientCode) {
	        ingredientMapper.deleteIngredient(code);
	    }
	    
	    return 1; // 삭제 성공
	}

	@Override
	public String selectIngredientCode() {

		return ingredientMapper.selectIngredientCode();
	}

	@Override
	public String selectIngredientName(String productName, String productCode) {

		return ingredientMapper.selectIngredientName(productName, productCode);
	}

}
