package com.breadflow.app.bom.service;

import lombok.Data;

@Data
public class BomVO {
	private String bomCode;			// BOM코드
	private Integer consumption;	// 소모량
	private String unit;			// 단위
	private String note;			// 비고
	private String ingredientCode;	// 재료코드
	private String productCode;		// 제품코드
	
}
