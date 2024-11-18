package com.breadflow.app.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breadflow.app.common.mapper.CategoryMapper;
import com.breadflow.app.common.service.CategoryService;
import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.SearchItemVO;
import com.breadflow.app.common.service.SearchOptionVO;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	public CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryVO> getCategories() {
		return categoryMapper.selectCategories();
	}
	
	@Override
	public List<SearchItemVO> getItems(SearchOptionVO option) {
		return categoryMapper.selectItems(option);
	}
	
}
