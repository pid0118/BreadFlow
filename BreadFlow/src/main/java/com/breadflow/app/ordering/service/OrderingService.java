package com.breadflow.app.ordering.service;

import java.util.Map;

public interface OrderingService {
	public Map<String, Object> selectOrderingList(String status, String sort, int page); // 발주 현황 조회
	public int insertOrdering(Map<String, Object> ordering); // 발주 신청
	public int updateOrderingApprovalCancel(String no, String reason); // 발주 취소
}
