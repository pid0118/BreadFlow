package com.breadflow.app.inout.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.inout.mapper.InOutMapper;
import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.OutstoreVO;

@Service
public class InOutServiceImpl implements InOutService {
	public InOutMapper inOutMapper;
	
	public InOutServiceImpl(InOutMapper inOutMapper) {
		this.inOutMapper = inOutMapper;
	}

	@Override
	public List<InstoreVO> instoreList() {
		return inOutMapper.selectInstoreList();
	}

	@Override
	public List<OutstoreVO> outstoreList() {
		return inOutMapper.selectOutstoreList();
	}

	@Override
	public InstoreVO instoreInfo(InstoreVO instoreVO) {
		return inOutMapper.selectInstoreInfo(instoreVO);
	}

	@Override
	public OutstoreVO outstoreInfo(OutstoreVO outstoreVO) {
		return inOutMapper.selectOutstoreInfo(outstoreVO);
	}

	@Override
	public int instoreInsert(InstoreVO instoreVO) {
		int result = inOutMapper.insertInstoreInfo(instoreVO);
		return result == 1 ? Integer.parseInt(instoreVO.getInstoreNo()) : -1;
	}

	@Override
	public int outstoreInsert(OutstoreVO outstoreVO) {
		int result = inOutMapper.insertOutstoreInfo(outstoreVO);
		return result == 1 ? Integer.parseInt(outstoreVO.getOutstoreNo()) : -1;
	}
}
