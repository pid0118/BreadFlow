package com.breadflow.app.inout.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OutstoreVO {
	private String outstoreNo;
	private Integer outstoreGroupNo;
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private Date outstoreDate;
	private Integer outstoreQuantity;
	private String outstoreManager;
	private String ordersDetailNo;
	private String instoreNo;
	private String salesNo;
	private String orderingDetailCode;
	private String quantity;
	private Integer purchasePrice;
	private Integer price;
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private Date date;
	private String companyNo;
	
	private String unit;
	private String standard;
	private String outstoreCompany;
	private String instoreCompany;
	private String ordersItem;
	private Integer instoreQuantity;
	
	private String companyInput;
	private String div;
	
	private String orderingProduct;
	private String orderingIngredient;
	private String itemName;
	private String itemDiv;
}
