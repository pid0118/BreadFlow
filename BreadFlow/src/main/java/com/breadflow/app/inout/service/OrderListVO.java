package com.breadflow.app.inout.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderListVO {
	@DateTimeFormat(pattern = "yyyy년 MM월 dd일")
	private Date orderingDate;
	
	private String orderingIngredient;
	private String orderingProduct;
	private Integer quantity;
	private String standard;
	private String unit;
	
	private Integer outstoreQuantity;
	
	private String itemDiv;
}
