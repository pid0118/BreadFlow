package com.breadflow.app.ordering.service;

import java.util.Date;

import lombok.Data;

@Data
public class OrderingVO {
	private String orderingCode; // 발주 코드
	private Date orderingDate; // 발주 일자
	private String orderingRequestManager;	// 발주 요청자
	private String orderingCompany; // 발주처
	private int totalPrice; // 총 금액
	private String approvalWhether; // 발주 승인 여부
	private String orderingApprovalManger; // 발주 승인자
	private String orderformNo; // 발주서 번호
	private Date deliveryDesireDate; // 납기 희망 일자
	private String companyNo; // 회사 번호
}
