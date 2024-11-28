package com.breadflow.app.mtrqplan.service;

import java.util.Date;

import lombok.Data;

@Data
public class MtrqplanVO {
	//== matrequired_plan 테이블 관련 VO ==//
	String	matrequiredPlanNo;		// 자재소요 계획 번호
	String	productionPlanNo;		// 생산 계획 번호
	Date	writeDate;				// 작성 일자
	Date	startDate;				// 시작 일자
	Date	lastDate;				// 마감 일자
	String	deliveryLocation;		// 납품 위치
	String	supplyCompany;			// 공급(공유) 업체
	String	writer;					// 작성자
	
	//== matrequired_plan_detail 테이블 관련 VO ==//
	String	productCode;			// 계획 코드
	Integer	planQuantity;			// 계획 수량
	String	unit;					// 단위
	String	other;					// 기타사항
	String	progressSituation;		// 진행 상세
	String	materialDetailNo;		// 자재 상세 번호
	
	//== ingredient(재료) 테이블 관련 VO ==//
	String	major;					// 대분류
	String	sub;					// 소분류
	String	ingredientCode;			// 재료코드
	String	ingredientName;			// 재료명
	String	unitName;				// 단위 이름
}
