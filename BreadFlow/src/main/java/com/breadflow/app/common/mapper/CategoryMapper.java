package com.breadflow.app.common.mapper;

import java.util.List;

import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.SearchItemVO;
import com.breadflow.app.common.service.SearchOptionVO;

public interface CategoryMapper {
	public List<CategoryVO> selectCategories();
	public List<SearchItemVO> selectItems(SearchOptionVO option);
	public int selectItemPaging(SearchOptionVO option);
}
