package com.breadflow.app.inout.service;

import java.util.Date;

import lombok.Data;

@Data
public class OrderListVO {
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
	
	private Integer outstoreQuantity;
	
	private String itemDiv;
	private String instoreDiv;
}
