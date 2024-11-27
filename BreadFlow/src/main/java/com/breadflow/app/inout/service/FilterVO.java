package com.breadflow.app.inout.service;

import lombok.Data;

@Data
public class FilterVO {
	private String companyInput;
	private String clearTable;
	
	private String comp;
	private String prd;
	private String ing;
	private String item;
	private String year;
	private String month;
	private String startDt;
	private String endDt;
	
	private String disposal;
	private String checked;
	private String unchecked;
	private String confirmComp;
	private String div;
	
	private Integer page;
	private Integer pageSize;
}
