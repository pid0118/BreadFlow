package com.breadflow.app.orders.service;

import java.util.Date;

import lombok.Data;

@Data
public class OrdersVO {
	private String orderingCode;		// 발주 코드
	private Date orderingDate;			// 발주 일자
	private Date deliveryDesireDate;	// 납기 희망일자
	private String companyName;			// 발주처
	private int totalPrice;				// 총 금액
}
