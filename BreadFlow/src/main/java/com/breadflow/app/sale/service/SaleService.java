package com.breadflow.app.sale.service;

import java.util.List;
import java.util.Map;

import com.breadflow.app.product.service.ProductVO;

import jakarta.servlet.http.HttpSession;

public interface SaleService {
	// 본사 가맹점 정보 / 매출 조회
	public List<SaleVO> selectSaleList();
	
	// POS 제품 리스트 조회
	public List<SaleVO> selectSaleOffice(String comNo);
	
	// 본사 : 가맹점 일매출 가져오기
	public List<SaleVO> selectSaleDetailOffice(String comNo, String saleDate);
	
	// POS 제품 리스트 조회
	public List<ProductVO> selectProductList(String category);
	
	// POS 주문 버튼 클릭시 제품 상세 등록
	public int insertSale(List<PosVO> saleVO);
	
	// 가맹점 : 일매출 조회
	public List<PosVO> selectSales(String salesDate, HttpSession companyNo);
	
	// 마감정산 버튼눌렀을시 일매출 insert
	public int insertSales(HttpSession companyNo);
	
	// pos 마감 하기 전 상태 제품 상세보기
	public List<PosVO> selectDetailSale(HttpSession companyNo);
	
	// chart 매출 조회
	public List<PosVO> selectSaleChart(HttpSession companyNo);
	
	// chart 매출
	public List<PosVO> selectSaleProduct(HttpSession companyNo);

}
