
package com.breadflow.app.inout.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.inout.mapper.InOutMapper;
import com.breadflow.app.inout.service.FilterVO;
import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.ItemListVO;
import com.breadflow.app.inout.service.OrderListVO;
import com.breadflow.app.inout.service.OutstoreVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InOutServiceImpl implements InOutService {
	public final InOutMapper inOutMapper;

	@Override
	public List<InstoreVO> instoreList(FilterVO filterVO) {
		return inOutMapper.selectInstoreList(filterVO);
	}

	@Override
	public List<OutstoreVO> outstoreList(FilterVO filterVO) {
		return inOutMapper.selectOutstoreList(filterVO);
	}
	
	@Override
	public List<OrderListVO> orderListForInsert(FilterVO filterVO) {
		return inOutMapper.selectOrderListForInsert(filterVO);
	}

	@Override
	public List<InstoreVO> instoreListForInsert(FilterVO filterVO) {
		return inOutMapper.selectInstoreListForInsert(filterVO);
	}

	@Transactional
	@Override
	public int instoreInsert(List<InstoreVO> list) {
		int result = 0;
		for (InstoreVO instoreVO : list) {
			// 입고 등록
			result += inOutMapper.insertInstoreInfo(instoreVO);
			// 입고 등록 후 주문 상태 갱신
			result += inOutMapper.updateInstoreOrdering(instoreVO);
		}
		return result;
	}
	
	@Transactional
	@Override
	public int outstoreInsert(List<OutstoreVO> list) {
		int result = 0;
		for (OutstoreVO outstoreVO : list) {
			// 출고 등록
			result += inOutMapper.insertOutstoreInfo(outstoreVO);
			// 출고 등록 후 주문 상태 갱신
			result += inOutMapper.updateOutstoreOrdering(outstoreVO);
		}
		return result;
	}

	@Override
	public List<ItemListVO> itemList() {
		return inOutMapper.selectItemList();
	}

	@Override
	public int countInstore(FilterVO filterVO) {
		return inOutMapper.countInstoreList(filterVO);
	}

	@Override
	public int countOutstore(FilterVO filterVO) {
		return inOutMapper.countOutstoreList(filterVO);
	}

	@Override
	public int countOrderInsert(FilterVO filterVO) {
		return inOutMapper.countOrderListForInsert(filterVO);
	}

	@Override
	public int countInstoreInsert(FilterVO filterVO) {
		return inOutMapper.countInstoreListForInsert(filterVO);
	}
}