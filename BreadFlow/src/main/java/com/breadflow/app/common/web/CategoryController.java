package com.breadflow.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.common.service.CategoryService;
import com.breadflow.app.common.service.CategoryVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;
	
	@GetMapping("category/list")
	@ResponseBody
	public List<CategoryVO> categoryList() {
		return categoryService.selectCategory();
	}
	
	@GetMapping("category/subList")
	@ResponseBody
	public List<CategoryVO> categorySubList(@RequestParam String major) {
		return categoryService.selectCategorySub(major);
	}
	
}
