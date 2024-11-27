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

@Service
public class OrderingServiceImpl implements OrderingService{
	
	@Autowired
	public OrderingMapper orderingMapper;
	
	@Override
	public Map<String, Object> selectOrderingList(String status, String sort, int page) {
		List<String> list = Arrays.asList(status.split(",")) ;
	
		int totalPage = orderingMapper.selectOrderingPage(list, sort, page);
		List<OrderingVO> oList = orderingMapper.selectOrderingList(list, sort, page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", oList);
		map.put("page", totalPage);
		return map;
	}

	@Override
	@Transactional
	public int insertOrdering(Map<String, Object> ordering) {
		OrderingVO orderingVO = new OrderingVO();
		String desireDate = String.valueOf(ordering.get("deliveryDesireDate")).substring(0, 10);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date newDesireDate = date.parse(desireDate);
			orderingVO.setDeliveryDesireDate(newDesireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		orderingVO.setOrderingCode((String)ordering.get("orderingCode"));
		orderingVO.setOrderingRequestManager((String)ordering.get("orderingRequestManger"));
		orderingVO.setTotalPrice((int)ordering.get("totalPrice"));
		
		List<OrderingDetailVO> detailVOs = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> items = (List<Map<String, Object>>) ordering.get("itemCodes");

		for(int i = 0; i < items.size(); i++) {
			Map<String, Object> itemMap = (Map<String, Object>)items.get(i);
			OrderingDetailVO detailVO = new OrderingDetailVO();
			String pdCode = null; // 상품 코드
			String idCode = null; // 재료 코드
			String itemCode = (String) itemMap.get("itemCode");
			int itemQuan = (int) itemMap.get("itemQuan");
			String subCode = itemCode.substring(0, 2);
			
			if(subCode.equals("IB")) {
				pdCode = itemCode;
				detailVO.setOrderingProduct(pdCode);
			} else {
				idCode = itemCode;
				detailVO.setOrderingIngredient(idCode);
			}	
			detailVO.setQuantity(itemQuan);
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
		orderingMapper.updateOrderingAccept(orderingCode);
		return 0;
	}
	
	// 발주 상세 정보 조회
	@Override
	public List<OrderingDetailsVO> selectOrderingDetailList(String orderingCode) {
		return orderingMapper.selectOrderingDetailList(orderingCode);
	}

}
