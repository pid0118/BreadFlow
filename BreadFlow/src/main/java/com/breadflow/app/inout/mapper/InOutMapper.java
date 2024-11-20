
package com.breadflow.app.inout.mapper;

import java.util.List;

import com.breadflow.app.inout.service.InstoreVO;
import com.breadflow.app.inout.service.ItemListVO;
import com.breadflow.app.inout.service.OrderListVO;
import com.breadflow.app.inout.service.OutstoreVO;

public interface InOutMapper {
	public List<InstoreVO> selectInstoreList();
	public List<OutstoreVO> selectOutstoreList();
	public List<OrderListVO> selectOrderListForInsert();
	public List<InstoreVO> selectInstoreListForInsert();
	public int insertInstoreInfo(InstoreVO instoreVO);
	public int insertOutstoreInfo(OutstoreVO outstoreVO);
	public List<ItemListVO> selectItemList();
}