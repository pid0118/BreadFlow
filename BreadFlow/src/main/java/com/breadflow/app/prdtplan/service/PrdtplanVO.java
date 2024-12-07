package com.breadflow.app.prdtplan.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PrdtplanVO {
	//== 생산계획(production_plan) 테이블 관련 VO ==//
	private String 	productionPlanNo;		// 생산 계획 번호
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date	startDate;				// 시작일자
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date	lastDate;				// 마감일자
	private String	deliveryLocation;		// 납품 위치
	private String	productionCompany;		// 생산 업체
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date	writeDate;				// 작성 일자
	private String	writer;					// 작성자
	
	//== 생산계획 상세(production_plan_detail) 테이블 관련 VO ==//
	private String	productionDetailNo;		// 생산 상세 번호
	private String	productCode;			// 제품 코드
	private Integer planQuantity;			// 계획 수량
	private String	unit;					// 단위
	private String	other;					// 기타사항
	private String	progressSituation;		// 진행상태
	
	//== 제품(product) 테이블 관련 VO ==//
	private String  major;					// 대분류
	private String  sub;					// 소분류
	private String	productName;			// 제품 이름
	
	//== 파생되어진 VO ==//
	private String 	deliveryLocationNm;		// 납품위치 업체의 이름
	private String 	productionCompanyNm;	// 생산업체의 이름
	private Integer instoreGroupNo;			// 입고할 때의 그룹 번호
	private String  isContainPrdt;			// 생산계획에 연결되어졌냐 아니냐 판단
}
