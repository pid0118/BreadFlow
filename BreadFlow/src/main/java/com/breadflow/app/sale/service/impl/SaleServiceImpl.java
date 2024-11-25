package com.breadflow.app.sale.service.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
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
	public List<SaleVO> selectSaleList() {
		return saleMapper.selectSaleList();
	}

	@Override
	public List<ProductVO> selectProductList(String category) {
		return saleMapper.selectProductList(category);
	}
	
	@Transactional
	@Override
	public int insertSale(List<PosVO> list) {
		int result = 0;
		for(PosVO i : list) {
			result = saleMapper.insertSale(i);
		}
		return result;
	}

	@Override
	public int insertSales() {
		return saleMapper.insertSales();
	}

	@Override
	public List<PosVO> selectSales(String salesDate) {
		if(salesDate.equals("undefined")) {
			Date ndate = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM"); 
			salesDate = simpleDateFormat.format(ndate);
			System.out.println(salesDate);
		}
		return saleMapper.selectSales(salesDate);			
	}



}
