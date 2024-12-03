package com.breadflow.app.infer.service;

import java.util.List;

import com.breadflow.app.inout.service.FilterVO;

public interface InferService {
	// 전부
	public List<InferHistoryVO> inferList(FilterVO filterVO); // 본사일 시 전체 조회 / 본사 외일 시 로그인한 업체 내역 SELECT
	public int inferListCount(FilterVO filterVO);
	public List<CompanyVO> companyList();
	
	// 본사 외
	public List<InferDetailVO> inferListDetail(String inferNo);
	public InferAnswerVO inferAnswerDetail(String inferNo);
	
	// 본사 외
	public int inferInsert(List<InferDetailVO> inferDetailVO); // 입고 내역 선택해서 INSERT
	public int inferHistoryInsert(InferHistoryVO inferHistoryVO);
	
	// 본사
	public int inferAnswerInsert(InferAnswerVO inferAnswerVO); // 확인 후 답변 INSERT
}