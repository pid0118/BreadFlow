package com.breadflow.app.ordering.service;

import java.util.Date;

import lombok.Data;

@Data
public class OrderingVO {
	private String orderingCode;
	private Date orderingDate;
	private String orderingRequestManager;
	private int totalPrice;
	private String approvalWhether;
	private String orderingApprovalManger;
}
