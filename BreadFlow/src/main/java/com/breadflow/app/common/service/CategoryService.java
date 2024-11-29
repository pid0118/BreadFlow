package com.breadflow.app.common.service;

import java.util.List;

public interface CategoryService {

	public List<CategoryVO> selectCategory();
	
	public List<CategoryVO> selectCategorySub(String major);

	// 발주신청 모달 아이템 셀렉트
	public List<SearchItemVO> getItems(SearchOptionVO option);
	
	public int getItemPages(SearchOptionVO option);
	
	// bomPage 모달 unit 수정
	public List<SearchItemVO> selectItemsBom(SearchOptionVO option);
}
