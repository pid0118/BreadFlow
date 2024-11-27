package com.breadflow.app.mtrqplan.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MtrqplanController {

	@GetMapping("mtrqplanMng")
	public String mtrqplanMng(Model model) {
		return "mtrqplan/mtrqplanMng";
	}
}
