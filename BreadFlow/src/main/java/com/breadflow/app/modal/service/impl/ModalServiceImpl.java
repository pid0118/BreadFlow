package com.breadflow.app.modal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.breadflow.app.modal.mapper.ModalMapper;
import com.breadflow.app.modal.service.CoFindVO;
import com.breadflow.app.modal.service.ModalService;

@Service
public class ModalServiceImpl implements ModalService {
public ModalMapper modalMapper;
	
	public ModalServiceImpl(ModalMapper modalMapper) {
		this.modalMapper = modalMapper;
	}

	@Override
	public List<CoFindVO> companyList() {
		return modalMapper.selectCompanyList();
	}
}
