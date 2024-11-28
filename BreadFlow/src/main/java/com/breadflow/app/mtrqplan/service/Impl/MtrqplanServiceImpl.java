package com.breadflow.app.mtrqplan.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breadflow.app.mtrqplan.mapper.MtrqplanMapper;
import com.breadflow.app.mtrqplan.service.MtrqplanService;
import com.breadflow.app.mtrqplan.service.MtrqplanVO;

@Service
public class MtrqplanServiceImpl implements MtrqplanService {
	@Autowired
	private MtrqplanMapper mtrqplanMapper;

	@Override
	public List<MtrqplanVO> selectIngrdntList() {
		return mtrqplanMapper.selectIngrdntList();
	}


}
