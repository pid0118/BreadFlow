package com.breadflow.app.orders.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.orders.mapper.OrdersMapper;
import com.breadflow.app.orders.service.OrdersComVO;
import com.breadflow.app.orders.service.OrdersResponseVO;
import com.breadflow.app.orders.service.OrdersService;

import jakarta.servlet.http.HttpSession;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	public OrdersMapper ordersMapper;
	
	// 주문 정보 리스트
	@Override
	public Map<String, Object> selectOrdersList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true); // 결과값
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("contents", ordersMapper.selectOrdersList());
		map.put("data", dataMap); // 데이터값
		return map;
	}
	
	// 주문 정보 상세 리스트
	@Override
	public Map<String, Object> selectOrdersDetailList(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true); // 결과값
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("contents", ordersMapper.selectOrdersDetailList(code));
		map.put("data", dataMap); // 데이터값
		return map;
	}
	
	// 주문 신청 상세 리스트
	@Override
	public Map<String, Object> selectOrdersRequestList(String code) {
		String[] codeArr = code.split(",");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true); // 결과값
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("contents", ordersMapper.selectOrdersRequestList(codeArr));
		map.put("data", dataMap); // 데이터값
		return map;
	}
	
	// 주문 신청
	@Override
	@Transactional
	public String insertOrders(List<OrdersResponseVO> responseVO, HttpSession session) {
		String no = ordersMapper.selectOrdersNo();
		String manager = (String) session.getAttribute("name");
		ordersMapper.insertOrders(manager, no);
		responseVO.forEach(vo -> {
			ordersMapper.insertOrdersDetail(vo, no);
		});
		return "/order/list";
	}
	
	// 주문 현황 조회
	@Override
	public Map<String, Object> selectOrdersComList() {
		//List<String> list = Arrays.asList(status.split(",")); 
		List<OrdersComVO> oList = ordersMapper.selectOrdersComList();	// 전체 발주 조회
		Map<String, Object> map = new HashMap<>();
		map.put("data", oList);
		return null;
	}
	
}
