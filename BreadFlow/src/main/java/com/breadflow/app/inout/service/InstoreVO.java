
package com.breadflow.app.inout.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InstoreVO {
	private String instoreNo;
	@DateTimeFormat(pattern = "yyyy년 MM월 dd일")
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
	@DateTimeFormat(pattern = "yyyy년 MM월 dd일")
	private Date expirationDeadline;
	
	private String standard;
	private String unit;
	private String outstoreCompany;
	private String orderingProduct;

	private String memberNo;
	
	private String companyName;
}