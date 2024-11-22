package com.breadflow.app.sale.service;

import java.util.Date;

import lombok.Data;

@Data
public class SaleVO {
	private String region;
	private String companyName;
	private String brn;
	private String name;
	private Date contractDate;
	private int daySales;
	private String other;

}