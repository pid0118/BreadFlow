package com.breadflow.app.orders.service;

import lombok.Data;

@Data
public class OrdersRequestVO {
	private String itemName;			// 품목명
	private String itemCode;			// 품목코드
	private String unit;				// 단위
	private String standard;			// 규격
	private int quantity;				// 수량
	private String inCompany;			// 입고업체
	private String orderingDetailCode;	// 발주 상세 코드
}
