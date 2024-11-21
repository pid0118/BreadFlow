package com.breadflow.app.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.product.mapper.ProductMapper;
import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.ComCodeVO;
import com.breadflow.app.product.service.ProductService;
import com.breadflow.app.product.service.ProductVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	
	// 제품 전체조회
	@Override
	public List<ProductVO> selectProductList(ProductVO productVO) {
		return productMapper.selectProductList(productVO);
	}

	// 제품 단건조회
	@Override
	public ProductVO selectProduct(String productCode) {
		return productMapper.selectProduct(productCode);
	}
	
	// 제품 등록
	@Override
	public int insertProduct(ProductVO productVO) {
		return productMapper.insertProduct(productVO);
	}
	
	// 제품 수정
	@Override
	public int updateProductList(ProductVO productVO) {
		return productMapper.updateProductList(productVO);
	}
	
	// 제품 삭제
	@Override
	public int deleteProduct(ProductVO productVO) {
		return productMapper.deleteProduct(productVO);
	}

	// 제품코드 가져오기
	@Override
	public String selectProductCode() {
		// TODO Auto-generated method stub
		return productMapper.selectProductCode();
	}

	@Override
	public String selectProductName(String productName) {
		return productMapper.selectProductName(productName);
	}

	
}
