package com.breadflow.app.inout.service;

import java.util.List;

public interface InOutService {
	public List<InstoreVO> instoreList();
	public List<OutstoreVO> outstoreList();
//	public InstoreVO instoreInfo(InstoreVO instoreVO);
//	public OutstoreVO outstoreInfo(OutstoreVO outstoreVO);
	public int instoreInsert(InstoreVO instoreVO);
	public int outstoreInsert(OutstoreVO outstoreVO);
}
