package com.breadflow.app.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.breadflow.app.product.service.ProductVO;
import com.breadflow.app.sale.service.SaleVO;

@Mapper
public interface SaleMapper {
	// 본사 가맹점 정보 / 매출 조회
	public List<SaleVO> selectToSale();
	
	// POS 제품 리스트 조회
	public List<ProductVO> ProductList();
	
	// POS 카테고리 검색 조회
	public List<ProductVO> ProductInfo(String category);
	
	// 주문 버튼 눌렀을시 insert
	public int saleInsert();
	
}
