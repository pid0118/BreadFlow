package com.breadflow.app.account.service;

import java.util.List;

public interface AccountService {
	// 전체 조회
	public List<AccountVO> getList();

	// 회사(company) 단건 등록
	public int insertCompany(AccountVO accountVO);

	public int insertMember(AccountVO accountVO);

	public int updatePwMember(String id);

	public int deleteMember(String no);

	public int deleteMemberWhereCompany(String companyNo);

	public int deleteCompany(String companyNo);

	public int UpdateEmpMember(AccountVO accountVO);

	public int UpdateCompanyTel(AccountVO accountVO);

	public AccountVO chkIdPw(AccountVO accountVO);
}
