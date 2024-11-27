package com.breadflow.app.ingredient.service;

import lombok.Data;

@Data
public class IngredientVO {
	
	private String ingredientCode;			// 재료코드
	private String ingredientName;			// 재료 명
	private String origin;					// 원산지
	private String standard;				// 규격
	private String unit;					// 단위
	private Integer safeStockQuantity;		// 안전재고 수량
	private String ingredientImage;			// 재료 이미지
	private Integer expirationDeadline;		// 소비기한
	private String major;					// 대분류
	private String sub;						// 소분류
	private Integer purchasePrice;			// 매입 가격
	private Integer amount;					// 양
	private String unitName;          	// 단위명
	
}
