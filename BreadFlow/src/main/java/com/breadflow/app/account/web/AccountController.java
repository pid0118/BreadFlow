package com.breadflow.app.account.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.account.service.AccountService;
import com.breadflow.app.account.service.AccountVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	
	private AccountService accountService;	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("index")
	public String index() {
		return "account/index";
	}
	
	@GetMapping("welcome")
	public String welcome() {
		return "account/welcome";
	}
	
	@GetMapping("account")
	public String accountinfo() {
		return "account/accountinfo";
	}
	
	// 로그인 검사
	@PostMapping("loginCheck.do")
	@ResponseBody
	public int loginCheck(AccountVO accountVO) {
		System.out.println("id: " + accountVO.getId());
		System.out.println("pw: " + accountVO.getPassword());
		AccountVO acVO = accountService.chkIdPw(accountVO);
		
		if(acVO == null) {	// 로그인 실패
			return 0;
		}
		
		
		/*
		HttpServletRequest request = null;
		HttpSession session = request.getSession();
		
		session.setAttribute("id", acVO.getId());			// 아이디
		session.setAttribute("name", acVO.getName());		// 이름
		session.setAttribute("div", acVO.getPosition());	// 담당자/사원
		session.setAttribute("div", acVO.getDiv());			// 권한
		*/
		return 1;		// 로그인 성공
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
		return result + result2;
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
		System.out.println("\n" + accountVO + "\n");
		String position = accountVO.getPosition();
		System.out.println(position);
		int result = 0;
		
		if (position.equals("담당자")) {
			result = accountService.UpdateCompanyTel(accountVO);
			result = accountService.UpdateEmpMember(accountVO);
		} else {
			result = accountService.UpdateEmpMember(accountVO);		// 사원일 경우(연락처가 member만 update됨)
		}
		return result;
	}
	
	// 사원 신규등록 AJAX
	@PostMapping("insertEmployeeAccount.do")
	@ResponseBody
	public int employeeAccountInsert(AccountVO accountVO) {
		int result = accountService.insertMember(accountVO);
		return result;
	}
	
	@PostMapping("deleteAccount.do")
	@ResponseBody
	public int accountDelete(AccountVO accountVO) {
		String position = accountVO.getPosition();
		int result = 0;
		
		if(position.equals("담당자")) {						// 담당자일 경우 하위 사원을 모두 삭제하고 업체를 삭제
			result = accountService.deleteMemberWhereCompany(accountVO.getCompanyNo());
			result = accountService.deleteCompany(accountVO.getCompanyNo());
		} else {											// 사원일 경우 자기 자신만 삭제
			result = accountService.deleteMember(accountVO.getMemberNo());
		}
		
		return result;
	}
}
