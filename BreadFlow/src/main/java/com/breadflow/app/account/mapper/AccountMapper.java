package com.breadflow.app.account.mapper;

import java.util.List;

import com.breadflow.app.account.service.AccountVO;

public interface AccountMapper {

	// 전체조회
	public List<AccountVO> selectAccountList();

	// 회사(company) 단건 입력
	public int insertCompany(AccountVO accountVO);

	// 회원(member) 단건 입력(담당자인 경우)
	public int insertMember(AccountVO accountVO);

	// 특정 회원의 비밀번호 초기화
	public int updatePwMember(String id);

	// 회원(member) 단건 입력(사원인 경우)
	public int insertEmpMember(AccountVO accountVO);

	public int deleteMember(String no);
}
