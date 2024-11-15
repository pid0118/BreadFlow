package com.breadflow.app.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.product.mapper.ProductMapper;
import com.breadflow.app.product.service.ProductService;
import com.breadflow.app.product.service.ProductVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	
	// 제품 전체조회
	@Override
	public List<ProductVO> getListAll() {
		return productMapper.selectAllProductList();
	}

	// 제품 단건조회
	@Override
	public ProductVO getInfo(ProductVO productVO) {
		return productMapper.selectProduct(productVO);
	}
	
	// 제품 등록
	@Override
	public void insertProduct(ProductVO productVO) {
		productMapper.insertProduct(productVO);
	}
	
	// 제품 수정
	@Override
	public int updateProduct(ProductVO productVO) {
		return productMapper.updateProduct(productVO);
	}
	
	// 제품 삭제
	@Override
	public int deleteProduct(ProductVO productVO) {
		return productMapper.deleteProduct(productVO);
	}
	
}
