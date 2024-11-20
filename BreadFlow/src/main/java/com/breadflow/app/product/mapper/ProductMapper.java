package com.breadflow.app.product.mapper;

import java.util.List;

import com.breadflow.app.product.service.ProductVO;

public interface ProductMapper {
	// 전체조회
	public List<ProductVO> selectAllProductList();
		
	// 단건조회 - 조건 : 
	public ProductVO selectProduct(ProductVO productVO);
		
	// 등록  
	public void insertProduct(ProductVO productVO);
		
	// 수정
	public int updateProduct(ProductVO productVO);
		
	// 삭제
	public int deleteProduct(ProductVO productVO);
}
