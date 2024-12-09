package com.breadflow.app.ordering.service;

import lombok.Data;

@Data
public class OrderingDetailsVO {
	private String orderingDetailCode;	// 발주 상세 번호
	private int quantity;				// 수량
	private String itemname;			// 발주 품목
	private String unit;				// 단위
	private String standard;			// 규격
	private int price;					// 금액
	private String situation;			// 상태
}
