package com.breadflow.app.mtrqplan.service;

import java.util.List;

public interface MtrqplanService {

	// 재료 가져오기 팝업창에서 쓰일 재료 리스트 조회
	public List<MtrqplanVO> selectIngrdntList();

	public String insertMtrqplan(MtrqplanVO mtrqplanVO);

	public int insertMtrqplanDetails(List<MtrqplanVO> list);

	public MtrqplanVO selectMtrqplan(String id);

	public List<MtrqplanVO> selectMtrqplanDetails(String id);

	public int updateMtrqplanDetailForProgress(MtrqplanVO mtrqplanVO);

	public List<MtrqplanVO> selectMtrqplanForCom(String companyNo);

	public MtrqplanVO selectMtrqplanForForm(String id);

	public List<MtrqplanVO> selectMtrqplanDetailForGrid(String id);

	public int updateMtrqDetailForProgressToC4(MtrqplanVO mtrqplanVO);

	public int updateMatqDetailForProgressToC5(MtrqplanVO mtrqplanVO);

	public int insertInstoreForMtrqplan(List<MtrqplanVO> list, String writer, String company);

	public List<MtrqplanVO> selectBom(String id);

	public List<MtrqplanVO> selectPrdtplanLists();
}
