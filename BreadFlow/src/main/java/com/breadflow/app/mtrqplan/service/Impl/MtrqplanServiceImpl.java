package com.breadflow.app.mtrqplan.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breadflow.app.inout.mapper.InOutMapper;
import com.breadflow.app.mtrqplan.mapper.MtrqplanMapper;
import com.breadflow.app.mtrqplan.service.MtrqplanService;
import com.breadflow.app.mtrqplan.service.MtrqplanVO;

@Service
public class MtrqplanServiceImpl implements MtrqplanService {
	@Autowired
	private MtrqplanMapper mtrqplanMapper;
	
	@Autowired
	private InOutMapper inOutMapper;

	@Override
	public List<MtrqplanVO> selectIngrdntList() {
		return mtrqplanMapper.selectIngrdntList();
	}

	@Override
	public String insertMtrqplan(MtrqplanVO mtrqplanVO) {
		int result = mtrqplanMapper.insertMtrqplan(mtrqplanVO);
		return result == 1 ? mtrqplanVO.getMatrequiredPlanNo() : "";
	}

	@Override
	public int insertMtrqplanDetails(List<MtrqplanVO> list) {
		int result = 0;
		for(MtrqplanVO mvo : list) {
			mtrqplanMapper.insertMtrqplanDetail(mvo);
			result++;
		}
		return result;
	}

	@Override
	public MtrqplanVO selectMtrqplan(String productionPlanNo) {
		return mtrqplanMapper.selectMtrqplan(productionPlanNo);
	}

	@Override
	public List<MtrqplanVO> selectMtrqplanDetails(String matrequiredPlanNo) {
		return mtrqplanMapper.selectMtrqplanDetails(matrequiredPlanNo);
	}

	@Override
	public int updateMtrqplanDetailForProgress(MtrqplanVO mtrqplanVO) {
		return mtrqplanMapper.updateMtrqplanDetailForProgress(mtrqplanVO);
	}

	@Override
	public List<MtrqplanVO> selectMtrqplanForCom(String companyNo) {
		return mtrqplanMapper.selectMtrqplanForCom(companyNo);
	}

	@Override
	public MtrqplanVO selectMtrqplanForForm(String matrequiredPlanNo) {
		return mtrqplanMapper.selectMtrqplanForForm(matrequiredPlanNo);
	}

	@Override
	public List<MtrqplanVO> selectMtrqplanDetailForGrid(String matrequiredPlanNo) {
		return mtrqplanMapper.selectMtrqplanDetailForGrid(matrequiredPlanNo);
	}

	@Override
	public int updateMtrqDetailForProgressToC4(MtrqplanVO mtrqplanVO) {
		return mtrqplanMapper.updateMtrqDetailForProgressToC4(mtrqplanVO);
	}

	@Override
	public int updateMatqDetailForProgressToC5(MtrqplanVO mtrqplanVO) {
		return mtrqplanMapper.updateMatqDetailForProgressToC5(mtrqplanVO);
	}

	// 최종 생산이 완료되면 입고(instore) 테이블에 해당 계획 INSERT 
	@Override
	public int insertInstoreForMtrqplan(List<MtrqplanVO> list, String writer, String Company) {
		int result = 0;
		int groupNo = inOutMapper.getInstoreLastGroupNo();
		groupNo++;
		
		for (MtrqplanVO mvo: list) {
			mvo.setInstoreGroupNo(groupNo);
			mvo.setWriter(writer);
			mvo.setSupplyCompany(Company);
			mtrqplanMapper.insertInstoreForMtrqplan(mvo);
			result++;
		}
		return result;
	}

	@Override
	public List<MtrqplanVO> selectBom(String productionPlanNo) {
		return mtrqplanMapper.selectBom(productionPlanNo);
	}

	@Override
	public List<MtrqplanVO> selectPrdtplanLists() {
		return mtrqplanMapper.selectPrdtplanLists();
	}
}
