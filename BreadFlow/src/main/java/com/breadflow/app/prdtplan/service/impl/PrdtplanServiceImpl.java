package com.breadflow.app.prdtplan.service.impl;

import org.springframework.stereotype.Service;

import com.breadflow.app.prdtplan.mapper.PrdtplanMapper;
import com.breadflow.app.prdtplan.service.PrdtplanService;

@Service
public class PrdtplanServiceImpl implements PrdtplanService {
	
	private PrdtplanMapper prdtplanMapper;
	
	public PrdtplanServiceImpl(PrdtplanMapper prdtplanMapper) {
		this.prdtplanMapper = prdtplanMapper;
	}
	
	
	
	
}
