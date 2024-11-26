package com.breadflow.app.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<ProductVO> selectProductList(ProductVO productVO) {
		return productMapper.selectProductList(productVO);
	}

	// 제품 단건조회
	@Override
	public ProductVO selectProduct(String productCode) {
		ProductVO product = productMapper.selectProduct(productCode);
		
//		String unitCode = product.getUnit();
//		String unit = "";
//		if (unitCode.equals("j1")) {
//			unit = "g";
//		} else if (unitCode.equals("j2")) {
//			unit = "kg";
//		} else if (unitCode.equals("j3")) {
//			unit = "ml";
//		} else if (unitCode.equals("j4")) {
//			unit = "L";
//		} else  if (unitCode.equals("j5")){
//			unit = "EA";
//		}
//		
//		product.setUnit(unit);
		
		return product;
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
	@Transactional
	@Override
	public int deleteProduct(List<String> productCode) {
		
		int count = productMapper.selectOrderingProductCnt(productCode);
		
		if (count == 0) {
			for(int i = 0;i < productCode.size();i++ ) {
				productMapper.deleteProduct(productCode.get(i));
			}	
		}
		
		return count;
	}

	// 제품코드 가져오기
	@Override
	public String selectProductCode() {
		// TODO Auto-generated method stub
		return productMapper.selectProductCode();
	}

	@Override
	public String selectProductName(String productName, String productCode) {
		return productMapper.selectProductName(productName, productCode);
	}

	
}
