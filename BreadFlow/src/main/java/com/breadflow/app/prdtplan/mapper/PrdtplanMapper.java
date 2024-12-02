package com.breadflow.app.prdtplan.mapper;

import java.util.List;

import com.breadflow.app.prdtplan.service.PrdtplanVO;

public interface PrdtplanMapper {


	//== 생산관리(본사) 페이지에서 사용하는 매퍼 ==//
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


	// 생산관리 디테일 특정 id의 progress_situation 갱신(c1 -> c3)
	public int updatedetailForProgress(PrdtplanVO prdtplanVO);

	// 모달창에 쓰일 생산품 리스트 조회
	public List<PrdtplanVO> selectPrdtList();

	
	//== 생산관리(제조공장) 페이지에서 사용되는 매퍼 ==//
	// 특정 제조공장에 해당하는 생산관리 전체 조회
	public List<PrdtplanVO> selectPrdtplanListForCom(String companyNo);
	
	// 생산관리 디테일 특정 id의 progress_situation 갱신(c3 -> c4)
	public int updateDetailForProgressToC4(PrdtplanVO prdtplanVO);
	
	// 생산관리 디테일 특정 id의 progress_situation 갱신(c4 -> c5)
	public int updateDetailForProgressToC5(PrdtplanVO prdtplanVO);

	// 생산관리 디테일 입력
	public int insertPrdtplanDetailsForSelf(PrdtplanVO pvo);

	// 최종 생산이 완료되면 입고(instore) 테이블에 해당 계획 INSERT 
	public int insertInstoreForPrdtplan(PrdtplanVO prdtplanVO);

}
