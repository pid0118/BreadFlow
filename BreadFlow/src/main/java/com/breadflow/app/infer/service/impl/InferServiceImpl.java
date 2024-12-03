package com.breadflow.app.infer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.infer.mapper.InferMapper;
import com.breadflow.app.infer.service.CompanyVO;
import com.breadflow.app.infer.service.InferAnswerVO;
import com.breadflow.app.infer.service.InferDetailVO;
import com.breadflow.app.infer.service.InferHistoryVO;
import com.breadflow.app.infer.service.InferService;
import com.breadflow.app.inout.service.FilterVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InferServiceImpl implements InferService {
	public final InferMapper inferMapper;
	
	// 불량 내역
	@Override
	public List<InferHistoryVO> inferList(FilterVO filterVO) {
		return inferMapper.selectInferList(filterVO);
	}
	
	// 불량 상세 내역
	@Override
	public List<InferDetailVO> inferListDetail(String inferNo) {
		return inferMapper.selectInferListDetail(inferNo);
	}
	
	// 불량 상세 답변 내역
	@Override
	public InferAnswerVO inferAnswerDetail(String inferNo) {
		return inferMapper.selectInferAnswerDetail(inferNo);
	}
	
	// 불량 등록
	@Transactional
	@Override
	public int inferInsert(List<InferDetailVO> list) {
		// history 등록
		InferHistoryVO inferHistoryVO = new InferHistoryVO();
		inferHistoryVO.setConfirmLocation(list.get(0).getConfirmLocation());
		inferHistoryVO.setInferManager(list.get(0).getInferManager());
		inferMapper.insertInferHistory(inferHistoryVO);
		int result = 0;
		
		// detail 등록
		for (InferDetailVO inferDetailVO : list) {
			inferDetailVO.setInferNo(inferHistoryVO.getInferNo());
			result += inferMapper.insertInferDetail(inferDetailVO);
		}
		return result;
	}
	
	// 불량 내역 등록
	@Transactional
	@Override
	public int inferHistoryInsert(InferHistoryVO inferHistoryVO) {
		return inferMapper.insertInferHistory(inferHistoryVO);
	}
	
	// 불량 답변 등록
	@Transactional
	@Override
	public int inferAnswerInsert(InferAnswerVO inferAnswerVO) {
		int result = 0;
		result += inferMapper.insertInferAnswer(inferAnswerVO);
		result += inferMapper.updateInferHistory(inferAnswerVO);
		return result;
	}
	
	// 업체 목록
	@Override
	public List<CompanyVO> companyList() {
		return inferMapper.selectCompany();
	}
	
	// 불량 내역 페이징
	@Override
	public int inferListCount(FilterVO filterVO) {
		return inferMapper.countInferList(filterVO);
	}
}
