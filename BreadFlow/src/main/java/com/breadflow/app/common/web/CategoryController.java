package com.breadflow.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.common.service.CategoryService;
import com.breadflow.app.common.service.CategoryVO;
import com.breadflow.app.common.service.SearchItemVO;
import com.breadflow.app.common.service.SearchOptionVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;
	
	@GetMapping("category/list")
	@ResponseBody
	public List<CategoryVO> categoryList() {
		return categoryService.getCategories();
	}
	
	@PostMapping("search/item")
	@ResponseBody
	public List<SearchItemVO> itemList(@RequestBody SearchOptionVO option) {
		return categoryService.getItems(option);
	}
	
}
