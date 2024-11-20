package com.breadflow.app.sale.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.breadflow.app.product.service.ProductVO;
import com.breadflow.app.sale.service.PosVO;
import com.breadflow.app.sale.service.SaleVO;

@Mapper
public interface SaleMapper {
	// 본사 가맹점 정보 / 매출 조회
	public List<PosVO> selectSaleList();
	
	// POS 제품 리스트 조회
	public List<ProductVO> selectProductList(String category);
	
	// 주문 버튼 눌렀을시 insert
	public int insertSale(List<SaleVO> saleVO);
	
}
