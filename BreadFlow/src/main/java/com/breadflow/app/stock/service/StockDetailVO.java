package com.breadflow.app.stock.service;

import java.util.Date;

import lombok.Data;

@Data
public class StockDetailVO {
	private String companyName;			// 회사명
	private String orderingItem;		// 품목명
	private String unit;				// 단위
	private String standard;			// 규격
	private int stockQuantity;			// 재고량
	private int safeStockQuantity;		// 안전재고량
	private Date expirationDeadline;	// 유통기한
}
