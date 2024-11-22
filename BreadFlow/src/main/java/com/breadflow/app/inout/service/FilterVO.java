package com.breadflow.app.inout.service;

import lombok.Data;

@Data
public class FilterVO {
	private String companyInput;
	private String clear;
	private String comp;
	private String prd;
	private String ing;
	private String item;
	private String year;
	private String month;
	
	private String checked;
	private String unchecked;
	private String confirmComp;
}
