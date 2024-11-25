package com.breadflow.app.prdtplan.service;

import java.util.List;

public interface PrdtplanService {

	public String insertPrdtplan(PrdtplanVO prdtplanVO);

	public List<PrdtplanVO> selectPrdtplanList();

	public int insertPrdtplanDetail(List<PrdtplanVO> list);

}
