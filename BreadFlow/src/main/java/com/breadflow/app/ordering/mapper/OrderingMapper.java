package com.breadflow.app.ordering.mapper;

import java.util.List;

import com.breadflow.app.ordering.service.OrderingVO;

public interface OrderingMapper {
	public List<OrderingVO> selectOrderingList();
}
