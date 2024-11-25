package com.breadflow.app.prdtplan.mapper;

import java.util.List;

import com.breadflow.app.prdtplan.service.PrdtplanVO;

public interface PrdtplanMapper {

	// 생산관리 단건 입력
	public int insertPrdtplan(PrdtplanVO prdtplanVO);
	
	// 생산관리 전체조회
	public List<PrdtplanVO> selectPrdtplanList();

	// 생산관리 디테일 단건 입력
	public int insertPrdtplanDetail(PrdtplanVO pvo);
	
	// 생산관리 단건 조회
	public void selectPrdtplan(String productionPlanNo);

}
