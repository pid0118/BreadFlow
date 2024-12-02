package com.breadflow.app.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breadflow.app.account.mapper.AccountMapper;
import com.breadflow.app.account.service.AccountService;
import com.breadflow.app.account.service.AccountVO;
import com.breadflow.app.account.service.EncryptHelper;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private EncryptHelper encryptHelper;
	
	@Autowired
	private AccountMapper accountMapper;
	
	/*
	public AccountServiceImpl(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}
	*/
	
	@Override
	public List<AccountVO> selectMemberList(AccountVO accountVO) {
		return accountMapper.selectMemberList(accountVO);
	}

	@Override
	public int insertCompany(AccountVO accountVO) {
		int result = accountMapper.insertCompany(accountVO);
		return result;
	}

	// 회원 신규 입력
	@Override
	public int insertMember(AccountVO accountVO){
		// [박진석|241202] 비밀번호 암호화
		String password = accountVO.getPassword();
		
		if(password == null || password == "") {
			password = "0000";
		}
		
		String encryptedPw = encryptHelper.encrypt(password);
		accountVO.setPassword(encryptedPw);
		
		int result = accountMapper.insertMember(accountVO);
		return result;
	}

	// 비밀번호를 0000으로 초기화
	@Override
	public int updateMemberForPw(String id) {
		AccountVO accVO = new AccountVO();
		String pW0000 = "0000";
		String encryptedPw = encryptHelper.encrypt(pW0000);
		
		accVO.setId(id);
		accVO.setPassword(encryptedPw);
		
		int result = accountMapper.updateMemberForPw(accVO);
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
	public AccountVO selectMemberForLogin(AccountVO accountVO, String password) {
		AccountVO result = accountMapper.selectMemberForLogin(accountVO);
		String AccountPw = result.getPassword();
		
		System.out.println("[AccountServiceImpl] selectMemberForLogin - 암호화.ismatch: " + encryptHelper.isMatch(password, AccountPw));
		
		if(encryptHelper.isMatch(password, AccountPw)) {
			return result;
		} else {
			return null;
		}
		
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
		
		if(accountVO.getPassword() != null || accountVO.getPassword() != "") {
			String password = accountVO.getPassword();
			String encryptedPw = encryptHelper.encrypt(password);
			accountVO.setPassword(encryptedPw);
		}
		
		int result = accountMapper.updateMember(accountVO);
		return result;
	}

	
}
