
package com.breadflow.app.inout.mapper;

import java.util.List;

import com.breadflow.app.inout.service.FilterVO;
import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.ItemListVO;
import com.breadflow.app.inout.service.OrderListVO;
import com.breadflow.app.inout.service.OutstoreVO;

public interface InOutMapper {
	public List<InstoreVO> selectInstoreList(FilterVO filterVO);
	public List<OutstoreVO> selectOutstoreList(FilterVO filterVO);
	public List<OrderListVO> selectOrderListForInsert(FilterVO filterVO);
	public List<InstoreVO> selectInstoreListForInsert(FilterVO filterVO);
	public int insertInstoreInfo(InstoreVO instoreVO);
	public int insertOutstoreInfo(OutstoreVO outstoreVO);
	public List<ItemListVO> selectItemList();
}