package com.breadflow.app.common.mapper;

import java.util.List;

import com.breadflow.app.common.service.CategoryVO;

public interface CategoryMapper {
	public List<CategoryVO> selectCategory();
	
	public List<CategoryVO> selectCategorySub(String major);

}
