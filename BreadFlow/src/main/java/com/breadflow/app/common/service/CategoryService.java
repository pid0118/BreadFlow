package com.breadflow.app.common.service;

import java.util.List;

public interface CategoryService {
	public List<CategoryVO> getCategories();
	public List<SearchItemVO> getItems(SearchOptionVO option);
}
