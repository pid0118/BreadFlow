package com.breadflow.app.infer.mapper;

import java.util.List;

import com.breadflow.app.infer.service.CompanyVO;
import com.breadflow.app.infer.service.InferAnswerVO;
import com.breadflow.app.infer.service.InferDetailVO;
import com.breadflow.app.infer.service.InferHistoryVO;
import com.breadflow.app.inout.service.FilterVO;

public interface InferMapper {
	public List<InferHistoryVO> selectInferList(FilterVO filterVO);
	public List<InferDetailVO> selectInferListDetail(String inferNo);
	public InferAnswerVO selectInferAnswerDetail(String inferNo);
	public int insertInferDetail(InferDetailVO inferDetailVO);
	public int insertInferHistory(InferHistoryVO inferHistoryVO);
	public int updateInferHistory(InferAnswerVO inferAnswerVO);
	public int insertInferAnswer(InferAnswerVO inferAnswerVO);
	public List<CompanyVO> selectCompany();
}