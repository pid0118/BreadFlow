package com.breadflow.app.modal.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.modal.service.CoFindVO;
import com.breadflow.app.modal.service.ModalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ModalController {
	private final ModalService modalService;
	
	@GetMapping("modal/companyList")
	@ResponseBody
	public List<CoFindVO> getCompanyList() {
		return modalService.companyList();
	}
}
