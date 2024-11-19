package com.breadflow.app.inout.service;

import java.util.Date;

import lombok.Data;

@Data
public class OutstoreVO {
	private String outstoreNo;
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
	private String ordersItem;
	
	private String orderingProduct;
	private String orderingIngredient;
	
	private String ingredientName;
	private String productName;
	
	private String itemDiv;
}
