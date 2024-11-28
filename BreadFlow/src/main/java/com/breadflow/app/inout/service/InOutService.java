
package com.breadflow.app.inout.service;

import java.util.List;

public interface InOutService {
	public List<InstoreVO> instoreList(FilterVO filterVO);
	public List<OutstoreVO> outstoreList(FilterVO filterVO);
	public List<OrderListVO> orderListForInsert(FilterVO filterVO);
	public List<InstoreVO> instoreListForInsert(FilterVO filterVO);
	public int instoreInsert(List<InstoreVO> instoreVO);
	public int outstoreInsert(List<OutstoreVO> outstoreVO);
	public List<ItemListVO> itemList();
	
	public int countInstore(FilterVO filterVO);
	public int countOutstore(FilterVO filterVO);
	public int countOrderInsert(FilterVO filterVO);
	public int countInstoreInsert(FilterVO filterVO);
}