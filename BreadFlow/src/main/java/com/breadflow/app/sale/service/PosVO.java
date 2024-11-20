package com.breadflow.app.sale.service;

import java.util.Date;

import lombok.Data;
@Data
public class PosVO {
	private String saleNo; // 판매 상세내역번호
	private String productCode; // 제품명 > 코드
	private Integer salePrice; // 제품가격
	private Integer quantity; // 판매수량
	private String salesNo; // 일매출 번호
	private Date salesDate; // 매출일자
	private String companyName; // 가맹점명

}
