package com.breadflow.app.infer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.infer.mapper.InferMapper;
import com.breadflow.app.infer.service.InferAnswerVO;
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
	public List<InferHistoryVO> inferListDetail() {
		return inferMapper.selectInferListDetail();
	}
	
	@Transactional
	@Override
	public int inferInsert(List<InferHistoryVO> list) {
		int result = 0;
		for (InferHistoryVO inferHistoryVO : list) {
			result += inferMapper.insertInferHistory(inferHistoryVO);
		}
		return result;
	}
	
	@Transactional
	@Override
	public int inferUpdate(List<InferHistoryVO> list) {
		int result = 0;
		for (InferHistoryVO inferHistoryVO : list) {
			result += inferMapper.updateInferHistory(inferHistoryVO);
		}
		return result;
	}
	
	@Transactional
	@Override
	public int inferAnswerInsert(List<InferAnswerVO> list) {
		int result = 0;
		for (InferAnswerVO inferAnswerVO : list) {
			result += inferMapper.insertInferAnswer(inferAnswerVO);
		}
		return result;
	}
}
