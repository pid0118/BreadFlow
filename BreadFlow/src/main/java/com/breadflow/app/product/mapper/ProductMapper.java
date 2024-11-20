package com.breadflow.app.product.mapper;

import java.util.List;

import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.ComCodeVO;
import com.breadflow.app.product.service.ProductVO;

public interface ProductMapper {
	// 전체조회
	public List<ProductVO> selectAllProductList(ProductVO productVO);
		
	// 단건조회 - 조건 : 
	public ProductVO selectProduct(String productCode);
		
	// 등록  
	public int insertProduct(ProductVO productVO);
		
	// 수정
	public int updateProduct(ProductVO productVO);
		
	// 삭제
	public int deleteProduct(ProductVO productVO);
	
	// ProductCode 가져오기
	public String selectProductCode();
	

}
