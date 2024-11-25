package com.breadflow.app.account.service;

import java.util.List;

public interface AccountService {
	// 전체 조회
	public List<AccountVO> selectMemberList(AccountVO accountVO);

	// 회사(company) 단건 등록
	public int insertCompany(AccountVO accountVO);

	public int insertMember(AccountVO accountVO);

	public int updateMemberForPw(String id);

	public int deleteMember(String no);

	public int deleteMemberForCompany(String companyNo);

	public int deleteCompany(String companyNo);

	public int updateMemberForEmp(AccountVO accountVO);

	public int UpdateCompanyForTel(AccountVO accountVO);

	public AccountVO selectMemberForLogin(AccountVO accountVO);

	public List<AccountVO> selectCompanyList();

	public AccountVO selectMember(AccountVO accountVO);

	public int UpdateMember(AccountVO accountVO);
}
