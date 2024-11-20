package com.breadflow.app.ordering.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.breadflow.app.ordering.service.OrderingDetailVO;
import com.breadflow.app.ordering.service.OrderingService;
import com.breadflow.app.ordering.service.OrderingVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderingController {
	private final OrderingService orderingService;
	
	@GetMapping("ordering/insert")
	public String insertForm() {
		return "ordering/insert";
	}
	
	@PostMapping("ordering/insert")
	public String insertOrdering(@RequestBody Map<String, Object> ordering) {
		OrderingVO orderingVO = new OrderingVO();
		String orderDate = String.valueOf(ordering.get("orderingDate")).substring(0, 10);
		String desireDate = String.valueOf(ordering.get("deliveryDesireDate")).substring(0, 10);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date newOrderDate = date.parse(orderDate);
			Date newDesireDate = date.parse(desireDate);
			orderingVO.setOrderingDate(newOrderDate);
			orderingVO.setDeliveryDesireDate(newDesireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		orderingVO.setOrderingCode((String)ordering.get("orderingCode"));
		orderingVO.setOrderingRequestManager((String)ordering.get("orderingRequestManger"));
		orderingVO.setTotalPrice((int)ordering.get("totalPrice"));
		
		System.out.println(ordering.get("test"));
		List<OrderingDetailVO> detailVOs = new ArrayList<>();
		for(int i=0; i<=10; i++) {
			OrderingDetailVO detailVO = new OrderingDetailVO();
			detailVOs.add(detailVO);
		}
		// int result = orderingService.insertOrdering(orderingVO, orderingDetailVO);
		return "ordering/insert";
	}
}
