package com.breadflow.app.sale.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class PosVO {
	private String productCode; // 제품명 > 코드
	private Integer salePrice; // 제품가격
	private Integer quantity; // 판매수량
	private String companyName; // 가맹점명
	@JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul" )
	private Date salesDate; // 매출일
	private Integer daySales; // 매출
	
}
