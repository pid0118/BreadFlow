package com.breadflow.app.inout.service;

import java.util.Date;

import lombok.Data;

@Data
public class OrderListVO {
	private Date orderingDate;
	
	private String orderingIngredient;
	private String orderingProduct;
	private Integer quantity;
	private String standard;
	private String unit;
	private String orderingDetailCode;
	private String ingredientName;
	private String productName;
	private String ingExpirationDeadline;
	private String prdExpirationDeadline;
	
	private Integer outstoreQuantity;
	
	private String itemDiv;
	private String instoreDiv;
}
