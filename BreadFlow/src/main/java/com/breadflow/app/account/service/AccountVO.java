package com.breadflow.app.account.service;

import java.util.Date;

import lombok.Data;

@Data
public class AccountVO {
	//== 업체(company) 테이블 관련 VO ==//
	private String	companyNo;				// 업체고유번호
	private String	div;					// 구분
	private String	companyName;			// 업체명
	private String	region;					// 업체지역
	private String	companyAddress;			// 업체주소
	private String	companyTel;				// 업체연락처
	private String	brn;					// 사업자등록번호
	
	//== 회원(member) 테이블 관련 VO ==//
	private String	memberNo;				// 회원고유번호
	private String	id;						// 아이디
	private String	password;				// 비밀번호
	private String	name;					// 이름
	private String	tel;					// 연락처
	private String	other;					// 기타사항
	private String	position;				// 직책
	private Date	contractDate;			// 계약일자
	
}
