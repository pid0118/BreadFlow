package com.breadflow.app.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.account.mapper.AccountMapper;
import com.breadflow.app.account.service.AccountService;
import com.breadflow.app.account.service.AccountVO;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountMapper accountMapper;
	
	public AccountServiceImpl(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}
	
	@Override
	public List<AccountVO> getList() {
		return accountMapper.selectAccountList();
	}

	@Override
	public int insertCompany(AccountVO accountVO) {
		int result = accountMapper.insertCompany(accountVO);
		return result;
	}

	@Override
	public int insertMember(AccountVO accountVO) {
		int result = accountMapper.insertMember(accountVO);
		return result;
	}

	@Override
	public int updatePwMember(String id) {
		int result = accountMapper.updatePwMember(id);
		return result;
	}

	@Override
	public int deleteMember(String no) {
		int result = accountMapper.deleteMember(no);
		return result;
	}

	@Override
	public int deleteMemberWhereCompany(String companyNo) {
		int result = accountMapper.deleteMembersWhereCompany(companyNo);
		return result;
	}

	@Override
	public int deleteCompany(String companyNo) {
		int result = accountMapper.deleteCompany(companyNo);
		return result;
	}

	@Override
	public int UpdateEmpMember(AccountVO accountVO) {
		int result = accountMapper.updateEmpMember(accountVO);
		return result;
	}

	@Override
	public int UpdateCompanyTel(AccountVO accountVO) {
		int result = accountMapper.updateCompanyTel(accountVO);
		return result;
	}

	@Override
	public AccountVO chkIdPw(AccountVO accountVO) {
		AccountVO result = accountMapper.checkIdPw(accountVO);
		return result;
	}

	
}
