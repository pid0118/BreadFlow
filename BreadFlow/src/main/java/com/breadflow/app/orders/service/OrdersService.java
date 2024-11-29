package com.breadflow.app.orders.service;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

public interface OrdersService {
	public Map<String, Object> selectOrdersList(); // 주문 정보 리스트
	public Map<String, Object> selectOrdersDetailList(String code); // 주문 정보 상세 리스트
	public Map<String, Object> selectOrdersRequestList(String code); // 선택된 주문 신청 상세 리스트
	public String insertOrders(List<OrdersResponseVO> responseVO, HttpSession session); // 주문 신청
	public Map<String, Object> selectOrdersComList(); // 주문 현황 조회
}
