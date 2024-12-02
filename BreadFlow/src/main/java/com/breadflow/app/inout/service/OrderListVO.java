package com.breadflow.app.inout.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderListVO {
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private Date orderingDate;
	
	private String orderingIngredient;
	private String orderingProduct;
	private Integer quantity;
	private String unit;
	private String standard;
	private String orderingDetailCode;
	private String ingredientName;
	private String productName;
	private String itemName;
	private String expirationDeadline;
	private Integer purchasePrice;
	private Integer price;
	
	private String outstoreCompany;
	private String instoreCompany;
	
	private Integer outstoreQuantity;
	
	private String itemDiv;
	private String instoreDiv;
}
