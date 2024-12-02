package com.breadflow.app.account.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.account.service.AccountService;
import com.breadflow.app.account.service.AccountVO;
import com.breadflow.app.common.service.ComCodeService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * @author 박진석
 * @
 */
@Controller
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountService accountService;	
	private final ComCodeService comcodeService;
	
	
	@GetMapping("index")
	public String index() {
		return "account/index";
	}
	
	@GetMapping("welcome")
	public String welcome() {
		return "account/welcome";
	}
	
	@GetMapping("account")
	public String accountinfo(Model model, HttpSession session) {
		// 세션 MemberNo 사용.
		String memberNo = (String) session.getAttribute("memNo");	
		AccountVO accVO = new AccountVO();
		accVO.setMemberNo(memberNo);
		
		AccountVO accountvo = accountService.selectMember(accVO);
		model.addAttribute("account", accountvo);
		return "account/accountinfo";
	}
	
	// 로그아웃
	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/index";
	}
	
	// 로그인 검사
	@PostMapping("loginCheck.do")
	@ResponseBody
	public int loginCheck(AccountVO accountVO, HttpSession session) {
		System.out.println("id: " + accountVO.getId());
		System.out.println("pw: " + accountVO.getPassword());
		
		String pw = accountVO.getPassword();
		
		//TODO : bcrypt 인코더 또는 paswordendorcer 사용
		// match 함수 사용하여 비교
		
		AccountVO acVO = accountService.selectMemberForLogin(accountVO, pw);
		
		if(acVO == null) {	// 로그인 실패
			return 0;
		}
		
		session.setAttribute("memNo", acVO.getMemberNo());				// 회원번호
		session.setAttribute("id", acVO.getId());						// 아이디
		session.setAttribute("name", acVO.getName());					// 이름
		session.setAttribute("position", acVO.getPosition());			// 담당자/사원
		session.setAttribute("div", acVO.getDiv());						// 권한
		session.setAttribute("companyName", acVO.getCompanyName());		// 업체명
		session.setAttribute("companyNo", acVO.getCompanyNo());			// 업체코드
		session.setAttribute("companyAddress", acVO.getCompanyAddress());
		session.setAttribute("companyTel", acVO.getCompanyTel());
		session.setAttribute("brn", acVO.getBrn());
		return 1;		// 로그인 성공
	}
	
	// 계정 조회 페이지
	@GetMapping("accountList")
	public String accountList(Model model, AccountVO accountVO) {
		List<AccountVO> list = accountService.selectMemberList(accountVO);
		model.addAttribute("accounts", list);
		model.addAttribute("code0A",comcodeService.selectComCode("0A"));
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
		int result = accountService.updateMemberForPw(accountVO.getId());
		return result;
		// TODO 암호화 필요
		
	}
	
	@PostMapping("updateAccount.do")
	@ResponseBody
	public int accountUpdate(AccountVO accountVO) {
		System.out.println("\n" + accountVO + "\n");
		String position = accountVO.getPosition();
		System.out.println(position);
		int result = 0;
		
		if (position.equals("담당자")) {
			result = accountService.UpdateCompanyForTel(accountVO);
			result = accountService.updateMemberForEmp(accountVO);
		} else {
			result = accountService.updateMemberForEmp(accountVO);		// 사원일 경우(연락처가 member만 update됨)
		}
		return result;
	}
	
	// 사원 단건 업데이트
	@PostMapping("updateAccountInfo.do")
	@ResponseBody
	public int updateAccountInfo(AccountVO accountVO) {
		System.out.println("\n[AccountController.java] updateAccountInfo - accountVO: " + accountVO + "\n");
		
		int result = accountService.UpdateMember(accountVO);
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
			result = accountService.deleteMemberForCompany(accountVO.getCompanyNo());
			result = accountService.deleteCompany(accountVO.getCompanyNo());
		} else {											// 사원일 경우 자기 자신만 삭제
			result = accountService.deleteMember(accountVO.getMemberNo());
		}
		
		return result;
	}
	
	
	// 모달창으로 업체 조회하는 AJAX
	@GetMapping("getCompanys.do")
	@ResponseBody
	public List<AccountVO> getCompanyList(Model model) {
		List<AccountVO> list = accountService.selectCompanyList();
		model.addAttribute("getCompanys", list);
		
		System.out.println("\nlist: " + list + "\n");
		return list;
	}
	
	
	
}
