package com.breadflow.app.prdtplan.service;

import java.util.Date;

import lombok.Data;

@Data
public class PrdtplanVO {
	//== 생산계획(production_plan) 테이블 관련 VO ==//
	private String 	productionPlanNo;		// 생산 계획 번호
	private Date	startDate;				// 시작일자
	private Date	lastDate;				// 마감일자
	private String	deliveryLocation;		// 납품 위치
	private String	productionCompany;		// 생산 업체
	private Date	writeDate;				// 작성 일자
	private String	writer;					// 작성자
	
	//== 생산계획 상세(production_plan_detail) 테이블 관련 VO ==//
	private String	productionDetailNo;		// 생산 상세 번호
	private String	productCode;			// 제품 코드
	private Integer planQuantity;			// 계획 수량
	private String	unit;					// 단위
	private String	other;					// 기타사항
	private String	progressSituation;		// 진행상태
	
	//== 파생되어진 VO ==//
	private String deliveryLocationNm;		// 납품위치 업체의 이름
	private String productionCompanyNm;		// 생산업체의 이름
}
