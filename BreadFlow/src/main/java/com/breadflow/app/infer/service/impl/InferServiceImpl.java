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
	
	@Override
	public List<InferHistoryVO> inferList(FilterVO filterVO) {
		return inferMapper.selectInferList(filterVO);
	}
	
	@Override
	public List<InferDetailVO> inferListDetail(String inferNo) {
		return inferMapper.selectInferListDetail(inferNo);
	}
	
	@Override
	public InferAnswerVO inferAnswerDetail(String inferNo) {
		return inferMapper.selectInferAnswerDetail(inferNo);
	}
	
	@Transactional
	@Override
	public int inferInsert(List<InferDetailVO> list) {
		// history 등록
		InferHistoryVO inferHistoryVO = new InferHistoryVO();
		inferHistoryVO.setConfirmLocation(list.get(0).getConfirmLocation());
		inferMapper.insertInferHistory(inferHistoryVO);
		int result = 0;
		
		// detail 등록
		for (InferDetailVO inferDetailVO : list) {
			inferDetailVO.setInferNo(inferHistoryVO.getInferNo());
			result += inferMapper.insertInferDetail(inferDetailVO);
		}
		return result;
	}
	
	@Transactional
	@Override
	public int inferHistoryInsert(InferHistoryVO inferHistoryVO) {
		return inferMapper.insertInferHistory(inferHistoryVO);
	}

	@Transactional
	@Override
	public int inferAnswerInsert(InferAnswerVO inferAnswerVO) {
		int result = 0;
		result += inferMapper.insertInferAnswer(inferAnswerVO);
		result += inferMapper.updateInferHistory(inferAnswerVO);
		return result;
	}

	@Override
	public List<CompanyVO> companyList() {
		return inferMapper.selectCompany();
	}

	@Override
	public int inferListCount(FilterVO filterVO) {
		return inferMapper.countInferList(filterVO);
	}
}
