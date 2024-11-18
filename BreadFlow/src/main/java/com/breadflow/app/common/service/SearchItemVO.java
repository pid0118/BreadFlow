package com.breadflow.app.common.service;

import lombok.Data;

@Data
public class SearchItemVO {
	private String itemCode;
	private String itemName;
	private String unit;
	private String standard;
	private int purchasePrice;
}
