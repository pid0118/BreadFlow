package com.breadflow.app.prdtplan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.prdtplan.mapper.PrdtplanMapper;
import com.breadflow.app.prdtplan.service.PrdtplanService;
import com.breadflow.app.prdtplan.service.PrdtplanVO;

@Service
public class PrdtplanServiceImpl implements PrdtplanService {
	
	private PrdtplanMapper prdtplanMapper;
	
	public PrdtplanServiceImpl(PrdtplanMapper prdtplanMapper) {
		this.prdtplanMapper = prdtplanMapper;
	}

	@Override
	public String insertPrdtplan(PrdtplanVO prdtplanVO) {
		System.out.println("\n[PrdtplanServiceImpl.java] insertPrdtplan 접근 완료!\n");
		int result = prdtplanMapper.insertPrdtplan(prdtplanVO);
		return result == 1 ? prdtplanVO.getProductionPlanNo() : "" ;
	}

	@Override
	public List<PrdtplanVO> selectPrdtplanList() {
		return prdtplanMapper.selectPrdtplanList();
	}

	@Override
	public int insertPrdtplanDetail(List<PrdtplanVO> list) {
		int result = 0;
		for(PrdtplanVO pvo : list) {
			prdtplanMapper.insertPrdtplanDetail(pvo);
			result++;
		}
		return result;
	}

	@Override
	public PrdtplanVO selectPrdtplan(PrdtplanVO prdtplanVO) {
		return prdtplanMapper.selectPrdtplan(prdtplanVO);
		
	}

	@Override
	public List<PrdtplanVO> selectPrdtplanDetailList(PrdtplanVO prdtplanVO) {
		return prdtplanMapper.selectPrdtplanDetailList(prdtplanVO);
	}

	@Override
	public int updatedetailForProgress(PrdtplanVO prdtplanVO) {
		return prdtplanMapper.updatedetailForProgress(prdtplanVO);
	}


	@Override
	public List<PrdtplanVO> selectPrdtList() {
		return prdtplanMapper.selectPrdtList();
	}

	@Override
	public List<PrdtplanVO> selectPrdtplanListForCom(String companyNo) {
		return prdtplanMapper.selectPrdtplanListForCom(companyNo);
	}

	@Override
	public int updateDetailForProgressToC4(PrdtplanVO prdtplanVO) {
		return prdtplanMapper.updateDetailForProgressToC4(prdtplanVO);
	}

	@Override
	public int updateDetailForProgressToC5(PrdtplanVO prdtplanVO) {
		return prdtplanMapper.updateDetailForProgressToC5(prdtplanVO);
	}

	@Override
	public int insertPrdtplanDetailsForSelf(List<PrdtplanVO> list) {
		int result = 0;
		for(PrdtplanVO pvo : list) {
			prdtplanMapper.insertPrdtplanDetailsForSelf(pvo);
			result++;
		}
		return result;
	}

	// 최종 생산이 완료되면 입고(instore) 테이블에 해당 계획 INSERT 
	@Override
	public int insertInstoreForPrdtplan(List<PrdtplanVO> list, String writer) {
		int result = 0;
		for (PrdtplanVO pvo : list) {
			pvo.setWriter(writer);
			prdtplanMapper.insertInstoreForPrdtplan(pvo);
			result++;
		}
		return result;
	}

	
	
}
