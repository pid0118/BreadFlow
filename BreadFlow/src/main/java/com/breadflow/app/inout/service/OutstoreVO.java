package com.breadflow.app.inout.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OutstoreVO {
	private String outstoreNo;
	@DateTimeFormat(pattern = "yyyy년 MM월 dd일")
	private Date outstoreDate;
	private Integer outstoreQuantity;
	private String outstoreManager;
	private String ordersDetailNo;
	private String instoreNo;
	private String salesNo;
	
	private String standard;
	private String unit;
	private String outstoreCompany;
	private String instoreCompany;
	
	private String itemDiv;
}
