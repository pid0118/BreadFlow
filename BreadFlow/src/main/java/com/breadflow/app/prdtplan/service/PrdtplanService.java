package com.breadflow.app.prdtplan.service;

import java.util.List;

public interface PrdtplanService {

	public int insertPrdtplan(PrdtplanVO prdtplanVO);

	public List<PrdtplanVO> selectPrdtplanList();

}
