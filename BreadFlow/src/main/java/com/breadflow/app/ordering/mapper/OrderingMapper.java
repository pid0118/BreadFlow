package com.breadflow.app.ordering.mapper;

import java.util.List;

import com.breadflow.app.ordering.service.OrderingDetailVO;
import com.breadflow.app.ordering.service.OrderingVO;

public interface OrderingMapper {
	public List<OrderingVO> selectOrderingList(List<String> status, String sort, int page); // 전체 발주 조회
	public int selectOrderingPage(List<String> status, String sort, int page); // 발주 현황 전체 페이지 수
	public int insertOrdering(String code, OrderingVO orderingVO); // 발주 insert
	public int insertOrderingDetail(String code, OrderingDetailVO orderingDetailVO); // 발주 상세 insert
	public String selectOrderingCode(); // 발주코드 조회
	public int updateOrderingApprovalCancel(String no, String reason); // 발주 취소
	public int updateOrderingAccept(String orderingCode); // 발주 승인
}
