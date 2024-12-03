package com.breadflow.app.stock.service;

import lombok.Data;

@Data
public class StockVO {
	private String itemCode;		// 품목코드
	private String facilities;		// 시설
	private String major;			// 구분
	private String sub;				// 카테고리
	private String orderingItem;	// 품목명
	private String standard;		// 규격
	private int stockQuantity;		// 재고량
	private int safeStockQuantity;	// 안전재고량
	private int price;				// 매입 가격
}
