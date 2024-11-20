package com.breadflow.app.common.service;

import java.util.List;

public interface CategoryService {
	public List<CategoryVO> selectCategory();
	
	public List<CategoryVO> selectCategorySub(String major);
}
