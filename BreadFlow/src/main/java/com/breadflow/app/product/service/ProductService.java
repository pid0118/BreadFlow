package com.breadflow.app.product.service;

import java.util.List;

public interface ProductService {
	// 전체조회
	public List<ProductVO> selectProductList(ProductVO productVO);
	
	// 단건조회
	public ProductVO selectProduct(String productCode);
	
	// 등록
	public int insertProduct(ProductVO productVO);
	
	// 수정
	public int updateProductList(ProductVO productVO);
	
	// 삭제
	public int deleteProduct(List<String> productCode);
	
	// ProductCode 가져오기
	public String selectProductCode();
	
	// ProductName 가져오기
	public String selectProductName(String productName, String productCode);
	
}
