package com.breadflow.app.product.mapper;

import java.util.List;

import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.ComCodeVO;
import com.breadflow.app.product.service.ProductVO;

public interface ProductMapper {
	// 전체조회
	public List<ProductVO> selectProductList(ProductVO productVO);
		
	// 단건조회 - 조건 : 
	public ProductVO selectProduct(String productCode);
		
	// 등록  
	public int insertProduct(ProductVO productVO);
		
	// 수정
	public int updateProductList(ProductVO productVO);
		
	// 삭제
	public int deleteProduct(String productCode);
	
	// ProductCode 가져오기
	public String selectProductCode();
	
	// 제품명 단건조회 / 중복값 제거위해
	public String selectProductName(String productName);
	
	// 주문상세 주문품목 조회
	public List<String> selectOrdersItems();

}
