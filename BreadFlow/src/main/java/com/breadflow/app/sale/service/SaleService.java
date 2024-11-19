package com.breadflow.app.sale.service;

import java.util.List;

import com.breadflow.app.product.service.ProductVO;

public interface SaleService {
	// 본사 가맹점 정보 / 매출 조회
	public List<SaleVO> toGetList();
	
	// POS 제품 리스트 조회
	public List<ProductVO> getListAll();
	
	// POS 카테고리 검색 조회
	List<ProductVO> getInfo(String category);
	
}
