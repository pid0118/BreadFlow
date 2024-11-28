package com.breadflow.app.orders.mapper;

import java.util.List;

import com.breadflow.app.orders.service.OrdersDetailVO;
import com.breadflow.app.orders.service.OrdersRequestVO;
import com.breadflow.app.orders.service.OrdersVO;

public interface OrdersMapper {
	public List<OrdersVO> selectOrdersList(); // 주문 정보 리스트
	public List<OrdersDetailVO> selectOrdersDetailList(String code); // 주문 정보 상세 리스트
	public List<OrdersRequestVO> selectOrdersRequestList(String[] codes); // 선택된 주문 상세 정보 리스트
}
