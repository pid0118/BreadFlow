package com.breadflow.app.ingredient.mapper;

import java.util.List;

import com.breadflow.app.ingredient.service.IngredientVO;


public interface IngredientMapper {
	
	// 원부재료 목록 불러오기
	public List<IngredientVO> selectIngredientList(IngredientVO ingredientVO);
	
	// 원부재료 단건조회
	public IngredientVO selectIngredient(String ingredientCode);
	
	// 원부재료 등록
	public int insertIngredient(IngredientVO ingredientVO);	
	
	// 원부재료 수정
	public int updateIngredient(IngredientVO ingredientVO);
	
	// 원부재료 삭제
	public int deleteIngredient(String ingredientCode);
	
	//재료코드 불러오기
	public String selectIngredientCode();
	
	// 제품명 단건조회 / 중복값 제거위해
	public String selectIngredientName(String ingredientName, String ingredientCode);
	
	// 주문중 재품찾기
	public int selectOrderingIngredientCnt(List<String> ingredientCode);
	
}
