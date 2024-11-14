package com.breadflow.app.account.mapper;

import java.util.List;

import com.breadflow.app.account.service.AccountVO;

public interface AccountMapper {

	// 전체조회
	public List<AccountVO> selectAccountList();

	public int insertCompany(AccountVO accountVO);

	public int insertMember(AccountVO accountVO);
}
