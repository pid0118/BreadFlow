package com.breadflow.app.orders.service;

import lombok.Data;

@Data
public class OrdersDetailVO {
	private String orderingDetailCode;	// 발주 상세 코드
	private String itemName;			// 발주 품목
	private String unit;				// 발주 단위
	private String standard;			// 발주 규격
	private int quantity;				// 발주 수량
}
