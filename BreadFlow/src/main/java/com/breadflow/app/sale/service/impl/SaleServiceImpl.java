package com.breadflow.app.sale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.product.service.ProductVO;
import com.breadflow.app.sale.mapper.SaleMapper;
import com.breadflow.app.sale.service.PosVO;
import com.breadflow.app.sale.service.SaleService;
import com.breadflow.app.sale.service.SaleVO;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	public SaleMapper saleMapper;
	
	
	@Override
	public List<PosVO> selectSaleList() {
		return saleMapper.selectSaleList();
	}

	@Override
	public List<ProductVO> selectProductList(String category) {
		return saleMapper.selectProductList(category);
	}
	
	
	@Transactional
	@Override
	public int insertSale(List<SaleVO> list) {
		int result = 0;
		for(SaleVO i : list) {
			result = saleMapper.insertSale(list);
		}
		return result;
	}


}
