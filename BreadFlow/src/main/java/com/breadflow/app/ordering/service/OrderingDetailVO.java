package com.breadflow.app.ordering.service;

import lombok.Data;

@Data
public class OrderingDetailVO {
	private String orderingDetailCode;
	private int quantity;
	private String orderingIngredient;
	private String orderingProduct;
	private String orderingCode;
	private String situationCode;
}
