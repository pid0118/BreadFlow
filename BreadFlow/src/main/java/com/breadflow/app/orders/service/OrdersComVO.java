package com.breadflow.app.orders.service;

import java.util.Date;

import lombok.Data;

@Data
public class OrdersComVO {
	private String ordersNo;	// 주문 번호
	private Date ordersDate;	// 주문 일자
	private String manager;		// 주문 담당자
	private String inCompany;	// 입고 업체
}
