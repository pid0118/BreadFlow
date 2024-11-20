package com.breadflow.app.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.ordering.mapper.OrderingMapper;
import com.breadflow.app.ordering.service.OrderingDetailVO;
import com.breadflow.app.ordering.service.OrderingService;
import com.breadflow.app.ordering.service.OrderingVO;

@Service
public class OrderingServiceImpl implements OrderingService{
	@Autowired
	public OrderingMapper orderingMapper;
	
	@Override
	public List<OrderingVO> selectOrderingList() {
		return null;
	}

	@Override
	@Transactional
	public int insertOrdering(OrderingVO orderingVO, List<OrderingDetailVO> orderingDetailVO) {
		int result = -1;
		String code = orderingMapper.selectOrderingCode();
		orderingMapper.insertOrdering(code, orderingVO);
		for(int i = 0; i < orderingDetailVO.size(); i++) {
			result = orderingMapper.insertOrderingDetail(code, orderingDetailVO);
		}
		return result;
	}

}
