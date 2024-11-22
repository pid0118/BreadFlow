package com.breadflow.app.ordering.mapper;

import java.util.List;

import com.breadflow.app.ordering.service.OrderingDetailVO;
import com.breadflow.app.ordering.service.OrderingVO;

public interface OrderingMapper {
	public List<OrderingVO> selectOrderingList();
	public int insertOrdering(String code, OrderingVO orderingVO);
	public int insertOrderingDetail(String code, OrderingDetailVO orderingDetailVO);
	public String selectOrderingCode();
}
