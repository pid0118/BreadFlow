package com.breadflow.app.bom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.bom.mapper.BomMapper;
import com.breadflow.app.bom.service.BomService;
import com.breadflow.app.bom.service.BomVO;
import com.breadflow.app.product.service.ProductVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BomServiceImpl implements BomService{
	private final BomMapper bomMapper;
	
	@Override
	public List<ProductVO> selectProductList(ProductVO productVO) {
		
		return null;
	}

	@Override
	public BomVO selectBom(BomVO bomVO) {
		
		return null;
	}

	@Override
	public int insertBom(BomVO bomVO) {
		
		return 0;
	}

	@Override
	public int updateBom(BomVO bomVO) {
		
		return 0;
	}

//	@Override
//	public int deleteBom(BomVO bomVO) {
//		
//		return 0;
//	}
	
	
}
