package com.breadflow.app.common.mapper;

import java.util.List;

import com.breadflow.app.common.service.ComCodeVO;

public interface ComCodeMapper {
	// ComCode 전제조회
	public List<ComCodeVO> selectComCode(String codeRule);
}
