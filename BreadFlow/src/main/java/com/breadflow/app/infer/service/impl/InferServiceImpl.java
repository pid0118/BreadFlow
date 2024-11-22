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

@Service
public class InferServiceImpl implements InferService {
	public InferMapper inferMapper;
	
	public InferServiceImpl(InferMapper inferMapper) {
		this.inferMapper = inferMapper;
	}

	@Override
	public List<InferHistoryVO> inferList(FilterVO filterVO) {
		return inferMapper.selectInferList(filterVO);
	}
	
	@Override
	public List<InferDetailVO> inferListDetail(String inferNo) {
		return inferMapper.selectInferListDetail(inferNo);
	}
	
	@Transactional
	@Override
	public int inferInsert(List<InferDetailVO> list) {
		int result = 0;
		for (InferDetailVO inferDetailVO : list) {
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
	public int inferUpdate(InferAnswerVO inferAnswerVO) {
		return inferMapper.updateInferHistory(inferAnswerVO);
	}
	
	@Transactional
	@Override
	public int inferAnswerInsert(InferAnswerVO inferAnswerVO) {
		return inferMapper.insertInferAnswer(inferAnswerVO);
	}

	@Override
	public List<CompanyVO> companyList() {
		return inferMapper.selectCompany();
	}
}
