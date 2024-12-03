package com.breadflow.app.ordering.service;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

public interface OrderingService {
	public Map<String, Object> selectOrderingList(String status, String sort, int page, HttpSession session); // 발주 현황 조회
	public int insertOrdering(Map<String, Object> ordering, HttpSession session); // 발주 신청
	public String updateOrderingApprovalCancel(String no, String reason); // 발주 취소
	public int updateOrderingAccept(String orderingCode); // 발주 승인
	public List<OrderingDetailsVO> selectOrderingDetailList(String orderingCode); // 발주 상세 정보 조회
}
