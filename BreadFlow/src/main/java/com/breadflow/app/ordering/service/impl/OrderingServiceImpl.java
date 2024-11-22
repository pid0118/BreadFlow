package com.breadflow.app.ordering.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.ordering.mapper.OrderingMapper;
import com.breadflow.app.ordering.service.OrderingDetailVO;
import com.breadflow.app.ordering.service.OrderingService;
import com.breadflow.app.ordering.service.OrderingVO;

@Service
public class OrderingServiceImpl implements OrderingService{
	@Autowired
	public OrderingMapper orderingMapper;
	
	@Override
	public List<OrderingVO> selectOrderingList() {
		return null;
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
		List items = (List) ordering.get("itemCodes");

		for(int i = 0; i < items.size(); i++) {
			Map<String, Object> itemMap = (Map<String, Object>)items.get(i);
			OrderingDetailVO detailVO = new OrderingDetailVO();
			String pdCode = null;
			String idCode = null;
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

}
