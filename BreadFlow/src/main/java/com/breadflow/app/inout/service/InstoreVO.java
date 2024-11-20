
package com.breadflow.app.inout.service;

import java.util.Date;

import lombok.Data;

@Data
public class InstoreVO {
	private String instoreNo;
	private Date instoreDate;
	private String itemDiv;
	private String itemCode;
	private Integer instoreQuantity;
	private Integer outstoreQuantity;
	private Integer stockQuantity;
	private String facilitiesDivNo;
	private String lotNo;
	private String instoreManager;
	private String orderingDetailCode;
	private String instoreDiv;
	private String instoreDivNo;
	private Date expirationDeadline;
	
	private String standard;
	private String unit;
	private String outstoreCompany;
	private String instoreCompany;
	private String orderingProduct;
	private String orderingIngredient;
	
	private String ordersDetailNo;

	private String memberNo;
	
	private String ingredientName;
	private String productName;
	
	private String companyName;
}