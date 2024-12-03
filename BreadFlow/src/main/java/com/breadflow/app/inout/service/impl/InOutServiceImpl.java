
package com.breadflow.app.inout.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.infer.service.CompanyVO;
import com.breadflow.app.inout.mapper.InOutMapper;
import com.breadflow.app.inout.service.FilterVO;
import com.breadflow.app.inout.service.InOutService;
import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.ItemListVO;
import com.breadflow.app.inout.service.OrderListVO;
import com.breadflow.app.inout.service.OutstoreVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InOutServiceImpl implements InOutService {
	public final InOutMapper inOutMapper;
	
	// 입고 내역
	@Override
	public List<InstoreVO> instoreList(FilterVO filterVO) {
		return inOutMapper.selectInstoreList(filterVO);
	}
	
	// 출고 내역
	@Override
	public List<OutstoreVO> outstoreList(FilterVO filterVO) {
		return inOutMapper.selectOutstoreList(filterVO);
	}
	
	// 입고 등록용 발주 내역
	@Override
	public List<OrderListVO> orderListForInsert(FilterVO filterVO) {
		return inOutMapper.selectOrderListForInsert(filterVO);
	}
	
	// 출고 등록용 입고 내역
	@Override
	public List<InstoreVO> instoreListForInsert(FilterVO filterVO) {
		return inOutMapper.selectInstoreListForInsert(filterVO);
	}
	
	// 입고 등록
	@Transactional
	@Override
	public int instoreInsert(List<InstoreVO> list) {
		int result = 0;
		
		// 그룹 번호
		int groupNo = inOutMapper.getInstoreLastGroupNo();
		if (groupNo == 0) {
			groupNo = 1;
		}
		
		// 업체 순으로 정렬
		list.sort((InstoreVO o1, InstoreVO o2) -> o1.getOutstoreCompany().compareTo(o2.getOutstoreCompany()));
		
		String preNo = "";
		for (InstoreVO instoreVO : list) {
			// 업체가 바뀌면 그룹 번호 증가
			if (!preNo.equals(instoreVO.getOutstoreCompany())) {
				groupNo ++;
			}
			instoreVO.setInstoreGroupNo(groupNo);
			// 입고 등록
			result += inOutMapper.insertInstoreInfo(instoreVO);
			// 입고 등록 후 주문 상태 갱신
			result += inOutMapper.updateInstoreOrdering(instoreVO);
			preNo = instoreVO.getOutstoreCompany();
		}
		return result;
	}
	
	// 출고 등록
	@Transactional
	@Override
	public int outstoreInsert(List<OutstoreVO> list) {
		int result = 0;
		
		// 그룹 번호
		int groupNo = inOutMapper.getOutstoreLastGroupNo();
		if (groupNo == 0) {
			groupNo = 1;
		}
		
		// 업체 순으로 정렬
		list.sort((OutstoreVO o1, OutstoreVO o2) -> o1.getInstoreCompany().compareTo(o2.getInstoreCompany()));
		
		String preNo = "";
		for (OutstoreVO outstoreVO : list) {
			// 업체가 바뀌면 그룹 번호 증가
			if (!preNo.equals(outstoreVO.getInstoreCompany())) {
				groupNo ++;
			}
			outstoreVO.setOutstoreGroupNo(groupNo);
			// 출고 등록
			result += inOutMapper.insertOutstoreInfo(outstoreVO);
			// 출고 등록 후 주문 상태 갱신
			result += inOutMapper.updateOutstoreOrdering(outstoreVO);
			preNo = outstoreVO.getInstoreCompany();
		}
		return result;
	}
	
	// 품목 목록
	@Override
	public List<ItemListVO> itemList() {
		return inOutMapper.selectItemList();
	}
	
	// 입고 페이징
	@Override
	public int countInstore(FilterVO filterVO) {
		return inOutMapper.countInstoreList(filterVO);
	}
	
	// 출고 페이징
	@Override
	public int countOutstore(FilterVO filterVO) {
		return inOutMapper.countOutstoreList(filterVO);
	}
	
	// 입고 등록 발주 페이징
	@Override
	public int countOrderInsert(FilterVO filterVO) {
		return inOutMapper.countOrderListForInsert(filterVO);
	}
	
	// 출고 등록 입고 페이징
	@Override
	public int countInstoreInsert(FilterVO filterVO) {
		return inOutMapper.countInstoreListForInsert(filterVO);
	}
	
	// 입고 거래 명세서 내역
	@Override
	public List<InstoreVO> instoreModal(FilterVO filterVO) {
		return inOutMapper.getInstoreModal(filterVO);
	}
	
	// 출고 거래 명세서 내역
	@Override
	public List<OutstoreVO> outstoreModal(FilterVO filterVO) {
		return inOutMapper.getOutstoreModal(filterVO);
	}
	
	// 입고처 정보
	@Override
	public CompanyVO instoreComp(String companyNo) {
		return inOutMapper.getInstoreComp(companyNo);
	}
	
	// 출고처 정보
	@Override
	public CompanyVO outstoreComp(String companyNo) {
		return inOutMapper.getOutstoreComp(companyNo);
	}
}