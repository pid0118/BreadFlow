package com.breadflow.app.orders.service;

import lombok.Data;

@Data
public class OrdersResponseVO {
	private String itemCode;			// 품목코드
	private int quantity;				// 수량
	private int price;					// 금액 
	private String inCompanyNo;			// 입고업체번호
	private String outCompanyNo;		// 출고업체번호
	private String orderingDetailCode;	// 발주 상세 코드
}
