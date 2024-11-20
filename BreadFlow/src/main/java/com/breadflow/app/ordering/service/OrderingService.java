package com.breadflow.app.ordering.service;

import java.util.List;

public interface OrderingService {
	public List<OrderingVO> selectOrderingList();
	public int insertOrdering(OrderingVO orderingVO, List<OrderingDetailVO> orderingDetailVO);
}
