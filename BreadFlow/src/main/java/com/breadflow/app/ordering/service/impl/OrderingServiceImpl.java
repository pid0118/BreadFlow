package com.breadflow.app.ordering.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.ordering.mapper.OrderingMapper;
import com.breadflow.app.ordering.service.OrderingDetailVO;
import com.breadflow.app.ordering.service.OrderingDetailsVO;
import com.breadflow.app.ordering.service.OrderingService;
import com.breadflow.app.ordering.service.OrderingVO;

import jakarta.servlet.http.HttpSession;

@Service
public class OrderingServiceImpl implements OrderingService{
	
	@Autowired
	public OrderingMapper orderingMapper;
	
	@Override
	public Map<String, Object> selectOrderingList(String status, String sort, int page) {
		List<String> list = Arrays.asList(status.split(",")); // 상태 배열 , 기준으로 나누어 list
	
		int totalPage = orderingMapper.selectOrderingPage(list, sort, page);	// 총 페이지
		List<OrderingVO> oList = orderingMapper.selectOrderingList(list, sort, page);	// 전체 발주 조회
		Map<String, Object> map = new HashMap<>();
		map.put("data", oList);
		map.put("page", totalPage);
		return map;
	}

	@Override
	@Transactional
	public int insertOrdering(Map<String, Object> ordering, HttpSession session) {
		OrderingVO orderingVO = new OrderingVO();
		String desireDate = String.valueOf(ordering.get("deliveryDesireDate")).substring(0, 10);	// 납기 희망일자 
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");	// 날짜 포맷팅
		try {
			Date newDesireDate = date.parse(desireDate);
			orderingVO.setDeliveryDesireDate(newDesireDate);	// 발주 납기 희망일자
		} catch (ParseException e) {
			e.printStackTrace();
		}
		orderingVO.setOrderingCode((String)ordering.get("orderingCode"));	// 발주코드
		orderingVO.setOrderingRequestManager((String)session.getAttribute("name"));	// 발주 요청 담당자
		orderingVO.setTotalPrice((int)ordering.get("totalPrice"));	// 총 금액
		orderingVO.setCompanyNo((String)session.getAttribute("companyNo"));	// 발주 회사 번호
		
		List<OrderingDetailVO> detailVOs = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> items = (List<Map<String, Object>>) ordering.get("itemCodes");	// 품목 내역 데이터

		for(int i = 0; i < items.size(); i++) {
			Map<String, Object> itemMap = (Map<String, Object>)items.get(i);
			OrderingDetailVO detailVO = new OrderingDetailVO();
			String itemCode = (String) itemMap.get("itemCode"); // 품목 코드
			int itemQuan = (int) itemMap.get("itemQuan"); // 품목 수량
			String subCode = itemCode.substring(0, 2); // 품목 구분
			
			if(subCode.equals("IB")) {
				detailVO.setOrderingProduct(itemCode);	// 발주 제품
			} else {
				detailVO.setOrderingIngredient(itemCode);	// 발주 재료
			}	
			detailVO.setQuantity(itemQuan); // 발주 재료
			detailVOs.add(detailVO);
		}
		
		int result = -1;
		String code = orderingMapper.selectOrderingCode();
		orderingMapper.insertOrdering(code, orderingVO);
		for(int i = 0; i < detailVOs.size(); i++) {
			result = orderingMapper.insertOrderingDetail(code, detailVOs.get(i));
		}
		return result;
	}

	// 발주 거절
	@Override
	@Transactional
	public String updateOrderingApprovalCancel(String no, String reason) {
		Map<String, Object> itemMap = new HashMap<>();
		itemMap.put("no", no);
		itemMap.put("reason", reason);
		itemMap.put("result", "");
		orderingMapper.updateOrderingApprovalCancel(itemMap);
		System.out.println(itemMap.get("result"));
		return (String)itemMap.get("result");
	}

	// 발주 승인
	@Override
	public int updateOrderingAccept(String orderingCode) {
		String result = "";
		orderingMapper.updateOrderingAccept(orderingCode, result);
		System.out.println(result);
		return 0;
	}
	
	// 발주 상세 정보 조회
	@Override
	public List<OrderingDetailsVO> selectOrderingDetailList(String orderingCode) {
		return orderingMapper.selectOrderingDetailList(orderingCode);
	}

}
