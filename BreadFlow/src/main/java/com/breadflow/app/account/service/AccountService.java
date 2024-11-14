package com.breadflow.app.account.service;

import java.util.List;

public interface AccountService {
	// 전체 조회
	public List<AccountVO> getList();

	// 회사(company) 단건 등록
	public int insertCompany(AccountVO accountVO);

	public int insertMember(AccountVO accountVO);
}
