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
	public PrdtplanVO selectPrdtplan(PrdtplanVO prdtplanVO);
	
	// 생산관리 디테일 id에 맞는 여러건 조회
	public List<PrdtplanVO> selectPrdtplanDetailList(PrdtplanVO prdtplanVO);

	// 생산관리 디테일 특정 id의 progress_situation 갱신
	public int updatedetailForProgress(PrdtplanVO prdtplanVO);

	// 모달창에 쓰일 생산품 리스트 조회
	public List<PrdtplanVO> selectPrdtList();

}
