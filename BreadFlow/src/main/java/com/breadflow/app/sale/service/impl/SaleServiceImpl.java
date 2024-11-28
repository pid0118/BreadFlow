package com.breadflow.app.sale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.breadflow.app.common.service.DateUtil;
import com.breadflow.app.product.service.ProductVO;
import com.breadflow.app.sale.mapper.SaleMapper;
import com.breadflow.app.sale.service.PosVO;
import com.breadflow.app.sale.service.SaleService;
import com.breadflow.app.sale.service.SaleVO;

import jakarta.servlet.http.HttpSession;

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
	public int insertSales(PosVO name) {
		return saleMapper.insertSales(name);
	}

	@Override
	public List<PosVO> selectSales(String salesDate, HttpSession name) {
		if(salesDate.equals("undefined")) {
			salesDate = DateUtil.dashFormatDate(null, "yyyyMM");
		}
		return saleMapper.selectSales(salesDate, (String)name.getAttribute("companyNo"));			
	}

	@Override
	public List<PosVO> selectDetailSale(HttpSession companyNo) {
		return saleMapper.selectDetailSale((String)companyNo.getAttribute("companyNo"));
	}

	@Override
	public List<PosVO> selectSaleChart(HttpSession companyNo) {
		return saleMapper.selectSaleChart((String)companyNo.getAttribute("companyNo"));
	}

	@Override
	public List<PosVO> selectSaleProduct(HttpSession companyNo) {
		return saleMapper.selectSaleProduct((String)companyNo.getAttribute("companyNo"));
	}

}
