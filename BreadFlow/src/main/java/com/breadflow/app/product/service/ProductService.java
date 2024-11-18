package com.breadflow.app.product.service;

import java.util.List;

import com.breadflow.app.common.service.CategoryVO;

public interface ProductService {
	// 전체조회
	public List<ProductVO> getListAll();
	
	// 단건조회
	public ProductVO getInfo(String productCode);
	
	// 등록
	public void insertProduct(ProductVO productVO);
	
	// 수정
	public int updateProduct(ProductVO productVO);
	
	// 삭제
	public int deleteProduct(ProductVO productVO);
	
	// 카테고리 목록 가져오기  e -> vo로 변경
	public List<CategoryVO> getCategory(); 
}
