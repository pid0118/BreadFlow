
package com.breadflow.app.inout.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class InstoreVO {
	private String instoreNo;
	@DateTimeFormat(pattern = "yy/MM/dd")
	@JsonFormat(pattern = "yy/MM/dd")
	private Date instoreDate;
	private String itemDiv;
	private String itemCode;
	private Integer instoreQuantity;
	private String companyNo;
	private Integer stockQuantity;
	private String facilitiesDivNo;
	private String lotNo;
	private String instoreManager;
	private String orderingDetailCode;
	private String instoreDiv;
	private String instoreDivNo;
	private Integer expirationDeadline;
	private Integer purchasePrice;
	
	private String unit;
	private String standard;
	private String outstoreCompany;
	private String instoreCompany;
	private String orderingProduct;
	private String orderingIngredient;
	
	private String ordersDetailNo;

	private String memberNo;

	private String itemName;
	
	private String companyName;
	private String companyInput;
}