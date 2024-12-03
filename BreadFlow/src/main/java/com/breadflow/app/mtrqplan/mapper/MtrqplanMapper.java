package com.breadflow.app.mtrqplan.mapper;

import java.util.List;

import com.breadflow.app.mtrqplan.service.MtrqplanVO;

public interface MtrqplanMapper {
	
	//== 자재소요계획(본사) 페이지에서 사용하는 매퍼 ==//
	// 모달창에 쓰일 재료(ingredient) 전체 조회
	public List<MtrqplanVO> selectIngrdntList();

	// 자재소요계획 단건 입력
	public int insertMtrqplan(MtrqplanVO mtrqplanVO);

	// 자재소요계획 디테일 단건 입력
	public int insertMtrqplanDetail(MtrqplanVO mvo);

	public MtrqplanVO selectMtrqplan(String productionPlanNo);

	public List<MtrqplanVO> selectMtrqplanDetails(String matrequiredPlanNo);

	public int updateMtrqplanDetailForProgress(MtrqplanVO mtrqplanVO);

	//== 자재소요계획(공급업체) 페이지에서 사용하는 매퍼 ==//
	// 부모 테이블에서 쓰이는 자재소요계획 전체 조회
	public List<MtrqplanVO> selectMtrqplanForCom(String companyNo);

	// 좌측아래 form에 쓰이는 자재소요계획 단건 조회
	public MtrqplanVO selectMtrqplanForForm(String matrequiredPlanNo);

	// 자식 테이블에서 쓰이는 자재소요계획 디테일 단건 조회
	public List<MtrqplanVO> selectMtrqplanDetailForGrid(String matrequiredPlanNo);

	// 자재소요계획 진행상태(progress)를 c4(진행중)으로 update 
	public int updateMtrqDetailForProgressToC4(MtrqplanVO mtrqplanVO);

	// 자재소요계획 진행상태(progress)를 c5(완료)로 update 
	public int updateMatqDetailForProgressToC5(MtrqplanVO mtrqplanVO);

	// 자재소요계획이 완료됨에 따라 다음 프로세스(입고) 진행을 위해 instore 테이블 INSERT
	public int insertInstoreForMtrqplan(MtrqplanVO mtrqplanVO);

}