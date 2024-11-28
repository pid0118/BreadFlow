package com.breadflow.app.mtrqplan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.mtrqplan.service.MtrqplanService;
import com.breadflow.app.mtrqplan.service.MtrqplanVO;
import com.breadflow.app.prdtplan.service.PrdtplanService;
import com.breadflow.app.prdtplan.service.PrdtplanVO;

@Controller
public class MtrqplanController {
	
	@Autowired
	private PrdtplanService prdtplanService;
	
	@Autowired
	private MtrqplanService mtrqplanService;
	

	@GetMapping("mtrqplanMng")
	public String mtrqplanMng() {
		return "mtrqplan/mtrqplanMng";
	}
	
	@GetMapping("mtrqplanPrcs")
	public String mtrqpplanPrsc() {
		return "mtrqplan/mtrqplanPrcs";
	}
	
	@GetMapping("getPrdtPlanList")
	@ResponseBody
	public List<PrdtplanVO> getPrdtPlanList() {
		List<PrdtplanVO> list = prdtplanService.selectPrdtplanList();
		System.out.println("\n[MtrqplanController.java] getPrdtPlanList - list: " + list + "\n");
		return list;
	}
	
	@GetMapping("getIngrdntsList")
	@ResponseBody
	public List<MtrqplanVO> getIngrdntsList() {
		List<MtrqplanVO> list = mtrqplanService.selectIngrdntList();
		return list;
	}
	
	@PostMapping("insertMtrqplan")
	@ResponseBody
	public String insertMtrqplan(MtrqplanVO mtrqplanVO) {
		System.out.println("\n[MtrqplanController.java] insertMtrqplan - mtrqplanVO: " + mtrqplanVO + "\n");
		String result = mtrqplanService.insertMtrqplan(mtrqplanVO);
		return result;
	}
	
}
