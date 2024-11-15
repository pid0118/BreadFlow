
package com.breadflow.app.inout.service;

import java.util.List;

public interface InOutService {
	public List<InstoreVO> instoreList();
	public List<OutstoreVO> outstoreList();
	public List<OrderListVO> orderListForInsert();
	public List<InstoreVO> instoreListForInsert();
	public int instoreInsert(InstoreVO instoreVO);
	public int outstoreInsert(OutstoreVO outstoreVO);
	public List<ItemListVO> itemList();
}