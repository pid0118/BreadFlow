package com.breadflow.app.ingredient.service;

import java.util.List;

public interface IngredientService {
	
	// 원부재료 목록 불러오기
	public List<IngredientVO> selectIngredientList(IngredientVO ingredientVO);
	
	// 원부재료 단건조회
	public IngredientVO selectIngredient(String ingredientCode);
	
	// 원부재료 등록
	public int insertIngredient(IngredientVO ingredientVO);	
		
	// 원부재료 수정
	public int updateIngredient(IngredientVO ingredientVO);
		
	// 원부재료 삭제
	public int deleteIngredient(IngredientVO ingredientVO);
	
	//재료코드 불러오기
	public String selectIngredientCode();
	
	// 제품명 단건조회 / 중복값 제거위해
	public String selectIngredientName(String productName, String productCode);
	
}
