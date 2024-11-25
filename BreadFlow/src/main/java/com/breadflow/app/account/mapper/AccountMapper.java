package com.breadflow.app.account.mapper;

import java.util.List;

import com.breadflow.app.account.service.AccountVO;

public interface AccountMapper {

	// 전체조회
	public List<AccountVO> selectMemberList(AccountVO accountVO);

	// 회사(company) 단건 입력
	public int insertCompany(AccountVO accountVO);

	// 회원(member) 단건 입력(담당자인 경우)
	public int insertMember(AccountVO accountVO);

	// 특정 회원의 비밀번호 초기화
	public int updateMemberForPw(String id);

	// 회원(member) 단건 입력(사원인 경우)
	public int insertEmpMember(AccountVO accountVO);

	// member_no 기준으로 사원 단건 삭제
	public int deleteMember(String no);

	// 회사코드 기준으로 모든 사원 및 담당자 삭제
	public int deleteMemberForCompany(String companyNo);

	// 회사(업체) 삭제
	public int deleteCompany(String companyNo);

	// 회원(member) 수정
	public int updateMemberForEmp(AccountVO accountVO);

	public int UpdateCompanyForTel(AccountVO accountVO);

	// 아이디/비밀번호 체크
	public AccountVO selectMemberForLogin(AccountVO accountVO);

	// 업체 리스트 조회
	public List<AccountVO> selectCompanyList();

	// 계정 단건 조회
	public AccountVO selectMember(AccountVO accountVO);

	// 회원 단건 수정
	public int updateMember(AccountVO accountVO);
}
