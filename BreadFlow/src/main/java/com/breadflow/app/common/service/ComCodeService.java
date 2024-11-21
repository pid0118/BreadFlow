package com.breadflow.app.common.service;

import java.util.List;

public interface ComCodeService {
	// CodeVal 조회
	public List<ComCodeVO> selectComCode(String codeRule);
}
