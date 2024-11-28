package com.breadflow.app.mtrqplan.mapper;

import java.util.List;

import com.breadflow.app.mtrqplan.service.MtrqplanVO;

public interface MtrqplanMapper {
	
	//== 자재소요계획(본사) 페이지에서 사용하는 매퍼 ==//
	// 모달창에 쓰일 재료(ingredient) 전체 조회
	public List<MtrqplanVO> selectIngrdntList();

	// 자재소요계획 단건 입력
	public int insertMtrqplan(MtrqplanVO mtrqplanVO);

}