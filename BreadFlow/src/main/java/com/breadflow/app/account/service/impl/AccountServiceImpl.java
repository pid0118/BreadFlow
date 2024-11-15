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
		return 0;
	}
	
}
