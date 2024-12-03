package com.breadflow.app.stock.service;

import java.util.Map;

import jakarta.servlet.http.HttpSession;

public interface StockService {
	public Map<String, Object> selectStockList(String facilities, String major, String item, HttpSession session); // 재고 현황 조회
	public Map<String, Object> selectDetailStockList(String facilities, String itemCode, HttpSession session);	  // 재고 상세 현황 조회
}
