package com.breadflow.app.bom.service;

import java.util.List;

import com.breadflow.app.product.service.ProductVO;

public interface BomService {
	// 제품목록 불러오기
	public List<ProductVO> selectProductList(ProductVO productVO);
	
	// BOM정보 조회
<<<<<<< HEAD
	public List<BomVO> selectBom(BomVO bomVO);
=======
	public BomVO selectBom(String productCode);
>>>>>>> branch 'indeukk' of https://github.com/pid0118/BreadFlow.git
	
	// BOM 등록 (원재료)
	public int insertBom(List<BomVO> list);
	
	// BOM 수정
	public int updateBom(List<BomVO> list);
	
	// BOM 삭제
	//public int deleteBom(BomVO bomVO);
	
	
}
