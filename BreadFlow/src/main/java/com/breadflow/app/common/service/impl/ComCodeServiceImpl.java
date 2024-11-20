package com.breadflow.app.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breadflow.app.common.mapper.ComCodeMapper;
import com.breadflow.app.common.service.ComCodeService;
import com.breadflow.app.common.service.ComCodeVO;

@Service
public class ComCodeServiceImpl implements ComCodeService {
	@Autowired
	public ComCodeMapper comCodeMapper;

	@Override
	public List<ComCodeVO> selectComCode(String codeRule) {
		
		return comCodeMapper.selectComCode(codeRule);
	}
	
	
}
