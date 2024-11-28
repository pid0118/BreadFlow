package com.breadflow.app.sale.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SaleVO {
	private String region;
	private String companyNo; // 가맹점번호
	private String brn; 
	private String name; // 점주 성함
	private Date contractDate; // 계약일
	private int daySales; // 일매출		
	private String other; // 특이사항
	private String companyName; // 가맹점명 

}