package com.breadflow.app.product.service;

import java.util.List;

import lombok.Data;

@Data
public class ProductVO {
	private String productCode;			// 제품코드
	private String productName;			// 제품명
	private String expirationDeadline;	// 소비기한
	private Integer purchasePrice;		// 매입가격
	private Integer salePrice;			// 판매가격
	private Integer safeStockQuantity;	// 안전재고
	private String proplace;			// 생산지
	private String productImage;		// 제품 이미지
	private String major;				// 대분류
	private String sub;					// 소분류
	private String unit;				// 단위
	private String standard;			// 규격
	
	private List<String> subList;		// 검색조건
}
