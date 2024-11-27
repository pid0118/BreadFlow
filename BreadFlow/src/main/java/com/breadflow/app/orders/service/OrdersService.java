package com.breadflow.app.orders.service;

import java.util.Map;

public interface OrdersService {
	public Map<String, Object> selectOrdersList(); // 주문 정보 리스트
	public Map<String, Object> selectOrdersDetailList(String code); // 주문 정보 상세 리스트
}
