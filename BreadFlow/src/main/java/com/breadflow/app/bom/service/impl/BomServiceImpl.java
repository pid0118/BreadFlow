package com.breadflow.app.bom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.bom.mapper.BomMapper;
import com.breadflow.app.bom.service.BomService;
import com.breadflow.app.bom.service.BomVO;
import com.breadflow.app.prdtplan.service.PrdtplanVO;
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
	// bom조회
	@Override
<<<<<<< HEAD
	public List<BomVO> selectBom(BomVO bomVO) {
=======
	public BomVO selectBom(String productCode) {
>>>>>>> branch 'indeukk' of https://github.com/pid0118/BreadFlow.git
		
		return bomMapper.selectBom(bomVO);
	}
	
	
	
	// bom등록
	@Override
	public int insertBom(List<BomVO> list) {
		int result = 0;
		for(BomVO bomVO : list) {
			bomMapper.insertBom(bomVO);
			result++;
		}
		
		return result;
	}
	// bom수정
	@Override
	public int updateBom(List<BomVO> list) {
	  int result = 0;
	  for(BomVO bomVO : list) {
		  bomMapper.insertBom(bomVO);
		  result++;
	}
	  return result;
	}

//	@Override
//	public int deleteBom(BomVO bomVO) {
//		
//		return 0;
//	}
	
	
}
