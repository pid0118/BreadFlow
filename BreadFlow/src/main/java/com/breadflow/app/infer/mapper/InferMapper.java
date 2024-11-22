package com.breadflow.app.infer.mapper;

import java.util.List;

import com.breadflow.app.infer.service.InferAnswerVO;
import com.breadflow.app.infer.service.InferHistoryVO;
import com.breadflow.app.inout.service.FilterVO;

public interface InferMapper {
	public List<InferHistoryVO> selectInferList(FilterVO filterVO);
	public List<InferHistoryVO> selectInferListDetail();
	public int insertInferHistory(InferHistoryVO inferHistoryVO);
	public int updateInferHistory(InferHistoryVO inferHistoryVO);
	public int insertInferAnswer(InferAnswerVO inferAnswerVO);
}