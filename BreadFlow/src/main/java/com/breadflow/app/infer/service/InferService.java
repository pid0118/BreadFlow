package com.breadflow.app.infer.service;

import java.util.List;

import com.breadflow.app.inout.service.FilterVO;

public interface InferService {
	// 전부
	public List<InferHistoryVO> inferList(FilterVO filterVO); // 본사일 시 전체 조회 / 본사 외일 시 로그인한 업체 내역 SELECT
	
	// 본사 외
	public List<InferHistoryVO> inferListDetail();
	
	// 본사 외
	public int inferInsert(List<InferHistoryVO> inferHistoryVO); // 입고 내역 선택해서 INSERT
	
	// 본사
	public int inferUpdate(List<InferHistoryVO> inferHistoryVO); // 확인 시 확인 여부 UPDATE
	public int inferAnswerInsert(List<InferAnswerVO> inferAnswerVO); // 확인 후 답변 INSERT
}
