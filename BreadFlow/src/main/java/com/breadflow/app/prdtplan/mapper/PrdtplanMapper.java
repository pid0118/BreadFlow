package com.breadflow.app.prdtplan.mapper;

import java.util.List;

import com.breadflow.app.prdtplan.service.PrdtplanVO;

public interface PrdtplanMapper {

	// 생산조회 단건 입력
	public int insertPrdtplan(PrdtplanVO prdtplanVO);
	
	// 생산조회 전체조회
	public List<PrdtplanVO> selectPrdtplanList();

	public int insertPrdtplanDetail(PrdtplanVO pvo);

}
