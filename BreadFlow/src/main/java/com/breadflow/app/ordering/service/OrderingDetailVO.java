package com.breadflow.app.ordering.service;

import java.util.Date;

import lombok.Data;

@Data
public class OrderingDetailVO {
	private String orderingDetailCode;
	private Date deliveryDesireDate;
	private int quantity;
	private int price;
	private String standard;
	private String unit;
	private String outstoreCompany;
	private String orderformNo;
	private String orderingIngredient;
	private String orderingProduct;
	private String orderingCode;
	private String situationCode;
}
