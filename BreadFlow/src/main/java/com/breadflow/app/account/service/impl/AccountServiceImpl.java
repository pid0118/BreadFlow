package com.breadflow.app.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.account.mapper.AccountMapper;
import com.breadflow.app.account.service.AccountService;
import com.breadflow.app.account.service.AccountVO;
import com.breadflow.app.account.service.Encryptor;

@Service
public class AccountServiceImpl implements AccountService {

	private final Encryptor encryptor;	// 암호화하는 JBcrypt 가져옴
	private AccountMapper accountMapper;
	
	public AccountServiceImpl(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}
	
	@Override
	public List<AccountVO> selectMemberList(AccountVO accountVO) {
		return accountMapper.selectMemberList(accountVO);
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
	public int updateMemberForPw(String id) {
		int result = accountMapper.updateMemberForPw(id);
		return result;
	}

	@Override
	public int deleteMember(String no) {
		int result = accountMapper.deleteMember(no);
		return result;
	}

	@Override
	public int deleteMemberForCompany(String companyNo) {
		int result = accountMapper.deleteMemberForCompany(companyNo);
		return result;
	}

	@Override
	public int deleteCompany(String companyNo) {
		int result = accountMapper.deleteCompany(companyNo);
		return result;
	}

	@Override
	public int updateMemberForEmp(AccountVO accountVO) {
		int result = accountMapper.updateMemberForEmp(accountVO);
		return result;
	}

	@Override
	public int UpdateCompanyForTel(AccountVO accountVO) {
		int result = accountMapper.UpdateCompanyForTel(accountVO);
		return result;
	}

	@Override
	public AccountVO selectMemberForLogin(AccountVO accountVO) {
		AccountVO result = accountMapper.selectMemberForLogin(accountVO);
		return result;
	}

	@Override
	public List<AccountVO> selectCompanyList() {
		return accountMapper.selectCompanyList();
	}

	@Override
	public AccountVO selectMember(AccountVO accountVO) {
		return accountMapper.selectMember(accountVO);
	}

	@Override
	public int UpdateMember(AccountVO accountVO) {
		int result = accountMapper.updateMember(accountVO);
		return result;
	}

	
}
