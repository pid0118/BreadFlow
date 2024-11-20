package com.breadflow.app.common.service;

import java.util.List;

import lombok.Data;

@Data
public class SearchOptionVO {
	private List<String> ingredients;
	private List<String> products;
	private String name;
	private int page;
}
