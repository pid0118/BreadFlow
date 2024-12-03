package com.breadflow.app.stock.mapper;

import java.util.List;

import com.breadflow.app.stock.service.StockDetailVO;
import com.breadflow.app.stock.service.StockVO;

public interface StockMapper {
	public List<StockVO> selectStockList(String[] facilities, String[] majors, String itemName, String companyNo); // 재고 현황 조회
	public List<StockDetailVO> selectDetailStockList(String itemCode, String facilities, String companyNo); // 재고 상세 현황 조회
}
