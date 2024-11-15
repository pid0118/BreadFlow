package com.breadflow.app.product.service;

import java.util.List;

public interface ProductService {
	// 전체조회
	public List<ProductVO> getListAll();
	
	// 단건조회
	public ProductVO getInfo(ProductVO productVO);
	
	// 등록
	public void insertProduct(ProductVO productVO);
	
	// 수정
	public int updateProduct(ProductVO productVO);
	
	// 삭제
	public int deleteProduct(ProductVO productVO);
}
