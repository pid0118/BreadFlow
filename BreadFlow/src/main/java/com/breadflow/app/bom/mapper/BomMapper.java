package com.breadflow.app.bom.mapper;

import java.util.List;

import com.breadflow.app.bom.service.BomVO;
import com.breadflow.app.product.service.ProductVO;

public interface BomMapper {

	// 제품목록 불러오기
		public List<ProductVO> selectProductList(ProductVO productVO);
		
		// BOM정보 조회
		public List<BomVO> selectBom(BomVO bomVO);
		
		// BOM 등록 (원재료)
		public int insertBom(BomVO bomVO);
		
		// BOM 수정
		public int updateBom(BomVO bomVO);
		
		// BOM 삭제
		//public int deleteBom(BomVO bomVO);
		
}
