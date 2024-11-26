package com.breadflow.app.ordering.service;

import lombok.Data;

@Data
public class OrderingDetailsVO {
	private String orderingDetailCode;
	private int quantity;
	private String itemname;
	private String unit;
	private String standard;
	private int price;
}
