package com.breadflow.app.ordering.mapper;

import java.util.List;
import java.util.Map;

import com.breadflow.app.ordering.service.OrderingDetailVO;
import com.breadflow.app.ordering.service.OrderingDetailsVO;
import com.breadflow.app.ordering.service.OrderingVO;

public interface OrderingMapper {
	public List<OrderingVO> selectOrderingList(List<String> status, String sort, int page, String div); // 전체 발주 조회
	public int selectOrderingPage(List<String> status, String sort, int page, String div); // 발주 현황 전체 페이지 수
	public int insertOrdering(String code, OrderingVO orderingVO); // 발주 insert
	public int insertOrderingDetail(String code, OrderingDetailVO orderingDetailVO); // 발주 상세 insert
	public String selectOrderingCode(); // 발주코드 조회
	public int updateOrderingApprovalCancel(Map<String, Object> map); // 발주 취소
	public int updateOrderingAccept(String orderingCode, String result); // 발주 승인
	public List<OrderingDetailsVO> selectOrderingDetailList(String orderingCode); // 발주 상세 정보 조회	 
}
