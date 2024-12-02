package com.breadflow.app.orders.service;

import lombok.Data;

@Data
public class OrdersComDVO {
	private String ordersDetailNo;	// 주문 상세 번호
	private String itemName;		// 품목명
	private String unit;			// 단위
	private String standard;		// 규격
	private String outCompany;		// 출고업체
	private int quantity;			// 수량
	private String situation;		// 주문 상태
}
