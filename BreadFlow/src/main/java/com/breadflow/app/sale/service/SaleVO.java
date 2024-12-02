package com.breadflow.app.sale.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SaleVO {
	private String region;
	private String companyNo; // 가맹점번호
	private int quantity; // 수량
	private int sale_price; // 가격
	private String name; // 점주 성함
	private int daySales; // 일매출		
	private String other; // 특이사항
	private String companyName; // 가맹점명 
	private int rownum;
	@JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul" )
	private Date salesDate; // 매출일
	
	private String saleDate; // 매출일 문자열(파라미터)
	private String comNo;

}