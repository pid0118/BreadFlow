package com.breadflow.app.account.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.account.service.AccountService;
import com.breadflow.app.account.service.AccountVO;

@Controller
public class AccountController {
	
	private AccountService accountService;	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("index")
	public String index() {
		return "test/logout";
	}
	
	// 계정 조회 페이지
	@GetMapping("accountList")
	public String accountList(Model model) {
		List<AccountVO> list = accountService.getList();
		model.addAttribute("accounts", list);
		return "account/accountList";
	}
	
	// 담당자 member 및 company 삽입 AJAX
	@PostMapping("insertAccount.do")
	@ResponseBody
	public int mngAccountInsert(AccountVO accountVO) {
		int result = accountService.insertCompany(accountVO);
		int result2 = accountService.insertMember(accountVO);
		return result;
	}
	
	@PostMapping("ResetAccountPw.do")
	@ResponseBody
	public int passwordResetUpdate(AccountVO accountVO) {
		System.out.println("[AccountController.java] passwordResetUpdate - id: " + accountVO.getId());
		int result = accountService.updatePwMember(accountVO.getId());
		return result;
		
	}
	
	@PostMapping("updateAccount.do")
	@ResponseBody
	public int accountUpdate(AccountVO accountVO) {
		/*if(accountVO.getPosition() == "b1") {
			int result = accountService.mngUpdateCompany(accountVO);
			
		}*/
		return 0;
	}
	
	// 사원 신규등록 AJAX
	@PostMapping("insertEmployeeAccount.do")
	@ResponseBody
	public int employeeAccountInsert(AccountVO accountVO) {
		System.out.println("[AccountController.java] passwordResetUpdate - accountVO: " + accountVO);
		int result = accountService.insertMember(accountVO);
		return result;
	}
}
