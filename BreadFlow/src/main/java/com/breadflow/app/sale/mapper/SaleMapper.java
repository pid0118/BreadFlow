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
	public List<SaleVO> selectSaleList();
	
	// POS 제품 리스트 조회
	public List<ProductVO> selectProductList(String category);
	
	// 주문 버튼 눌렀을시 insert
	public int insertSale(PosVO saleVO);
	
	// 가맹점 일 매출 조회
	public List<SaleVO> selectSales();
	
	// 마감정산 버튼눌렀을시 일매출 insert
	public int insertSales();
	
}
