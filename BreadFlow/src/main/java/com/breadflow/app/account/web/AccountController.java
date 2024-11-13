package com.breadflow.app.account.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	@GetMapping("accountList")
	public String accountList() {
		return "account/accountList";
	}
}
