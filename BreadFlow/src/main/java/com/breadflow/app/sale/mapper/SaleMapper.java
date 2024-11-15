package com.breadflow.app.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.breadflow.app.sale.service.SaleVO;

@Mapper
public interface SaleMapper {
	// 본사 가맹점 정보 / 매출 조회
	public List<SaleVO> selectToSale();

	
}
