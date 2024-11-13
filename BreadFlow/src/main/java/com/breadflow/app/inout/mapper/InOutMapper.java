package com.breadflow.app.inout.mapper;

import java.util.List;

import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.OutstoreVO;

public interface InOutMapper {
	public List<InstoreVO> selectInstoreList();
	public List<OutstoreVO> selectOutstoreList();
//	public InstoreVO selectInstoreInfo(InstoreVO instoreVO);
//	public OutstoreVO selectOutstoreInfo(OutstoreVO outstoreVO);
	public int insertInstoreInfo(InstoreVO instoreVO);
	public int insertOutstoreInfo(OutstoreVO outstoreVO);
}
