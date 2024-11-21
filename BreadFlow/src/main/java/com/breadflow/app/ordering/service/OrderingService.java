package com.breadflow.app.ordering.service;

import java.util.List;
import java.util.Map;

public interface OrderingService {
	public List<OrderingVO> selectOrderingList();
	public int insertOrdering(Map<String, Object> ordering);
}
