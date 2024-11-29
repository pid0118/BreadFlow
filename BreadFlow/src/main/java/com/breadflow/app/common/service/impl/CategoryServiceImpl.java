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
	public List<CategoryVO> selectCategory() {
		return categoryMapper.selectCategory();
	}

	@Override
	public List<CategoryVO> selectCategorySub(String major) {
		// TODO Auto-generated method stub
		return categoryMapper.selectCategorySub(major);
	}
	
	@Override
	public List<SearchItemVO> getItems(SearchOptionVO option) {
		return categoryMapper.selectItems(option);
	}

	@Override
	public int getItemPages(SearchOptionVO option) {
		return categoryMapper.selectItemPaging(option);
	}

	// bomPage 모달 unit 수정
	@Override
	public List<SearchItemVO> selectItemsBom(SearchOptionVO option) {
		return categoryMapper.selectItemsBom(option);
	}
	
	
	
}
