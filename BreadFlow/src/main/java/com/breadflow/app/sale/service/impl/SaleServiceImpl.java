package com.breadflow.app.sale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breadflow.app.sale.mapper.SaleMapper;
import com.breadflow.app.sale.service.SaleService;
import com.breadflow.app.sale.service.SaleVO;

@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	public SaleMapper saleMapper;
	
	@Override
	public List<SaleVO> toGetList() {
		return saleMapper.selectToSale();
	}

}
