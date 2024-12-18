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
	public List<BomVO> selectBom(BomVO bomVO) {

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
		  
		 if(bomVO.getBomCode() != null) {
			 bomMapper.updateBom(bomVO);
		 } else {
			 bomMapper.insertBom(bomVO);
		 }
		  result++;
	  }
	  return result;
	}
	
	// bom 원재료 삭제
	@Override
	public int deleteBomIngredient(List<BomVO> list) {
		
		int result = 0;
		for(BomVO vo : list) {
			bomMapper.deleteBomIngredient(vo);
			result++;
		}
		
		
		return result;
	}

}
