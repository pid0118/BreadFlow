package com.breadflow.app.stock.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breadflow.app.stock.mapper.StockMapper;
import com.breadflow.app.stock.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	public StockMapper stockMapper;
	
	// 재고 현황 조회
	@Override
	public Map<String, Object> selectStockList(String facilities, String major, String item) {
		String[] facStrings = facilities.split(",");	// 시설 목록
		String[] majors = major.split(",");				// 구분 목록
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", true);	// 결과 값
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("contents", stockMapper.selectStockList(facStrings, majors, item));
		map.put("data", dataMap); // 데이터값
		return map;
	}

	@Override
	public Map<String, Object> selectDetailStockList(String facilities, String itemCode) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", true);	// 결과 값
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("contents", stockMapper.selectDetailStockList(itemCode, facilities));
		map.put("data", dataMap); // 데이터값
		return map;
	}

}
