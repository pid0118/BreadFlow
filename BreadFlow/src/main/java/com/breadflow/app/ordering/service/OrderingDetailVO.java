package com.breadflow.app.ordering.service;

import lombok.Data;

@Data
public class OrderingDetailVO {
	private String orderingDetailCode; // 발주 상세 코드
	private int quantity; // 수량
	private String orderingIngredient; // 발주 재료
	private String orderingProduct; // 발주 제품
	private String orderingCode; // 발주 코드
	private String situationCode; // 상태 코드
	
}
