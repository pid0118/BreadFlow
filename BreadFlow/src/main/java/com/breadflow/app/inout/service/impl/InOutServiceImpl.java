
package com.breadflow.app.inout.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.inout.mapper.InOutMapper;
import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.ItemListVO;
import com.breadflow.app.inout.service.OrderListVO;
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
	public List<OrderListVO> orderListForInsert() {
		return inOutMapper.selectOrderListForInsert();
	}

	@Override
	public List<InstoreVO> instoreListForInsert() {
		return inOutMapper.selectInstoreListForInsert();
	}

	@Transactional
	@Override
	public int instoreInsert(List<InstoreVO> list) {
		int result = 0;
		for (InstoreVO instoreVO : list) {
			result += inOutMapper.insertInstoreInfo(instoreVO);
		}
		return result;
	}
	
	@Transactional
	@Override
	public int outstoreInsert(List<OutstoreVO> list) {
		int result = 0;
		for (OutstoreVO outstoreVO : list) {
			result += inOutMapper.insertOutstoreInfo(outstoreVO);
		}
		return result;
	}

	@Override
	public List<ItemListVO> itemList() {
		return inOutMapper.selectItemList();
	}
}