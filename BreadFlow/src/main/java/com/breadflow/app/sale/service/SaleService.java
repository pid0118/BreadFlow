package com.breadflow.app.sale.service;

import java.util.List;
import java.util.Map;

import com.breadflow.app.product.service.ProductVO;

public interface SaleService {
	// 본사 가맹점 정보 / 매출 조회
	public List<SaleVO> selectSaleList();
	
	// POS 제품 리스트 조회
	public List<ProductVO> selectProductList(String category);
	
	// POS 주문 버튼 클릭시 제품 상세 등록
	public int insertSale(List<PosVO> saleVO);
	
	// 가맹점 : 일매출 조회
	public List<PosVO> selectSales(String salesDate);
	
	// 마감정산 버튼눌렀을시 일매출 insert
	public int insertSales();
	
}
