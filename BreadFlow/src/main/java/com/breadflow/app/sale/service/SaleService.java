package com.breadflow.app.sale.service;

import java.util.List;
import java.util.Map;

import com.breadflow.app.product.service.ProductVO;

public interface SaleService {
	// 본사 가맹점 정보 / 매출 조회
	public List<PosVO> selectSaleList();
	
	// POS 제품 리스트 조회
	public List<ProductVO> selectProductList(String category);
	
	// POS 주문 버튼 클릭시 제품 상세 등록
	public Map<String,Object> insertSale(List<SaleVO> sale);
	
}
