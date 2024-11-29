package com.breadflow.app.mtrqplan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("insertMtrqplanDetails")
	@ResponseBody
	public int insertMtrqplanDetails(@RequestBody List<MtrqplanVO> list) {
		int result = mtrqplanService.insertMtrqplanDetails(list);
		return result;
	}
	
	@GetMapping("selectMtrqplan")
	@ResponseBody
	public MtrqplanVO selectMtrqplan(@RequestParam String id) {
		System.out.println("\n[MtrqplanController.java] selectMtrqplan - mtrqPlanNo: " + id + "\n");
		MtrqplanVO mVO = mtrqplanService.selectMtrqplan(id);
		return mVO;
	}
	
	@GetMapping("selectMtrqplanDetails")
	@ResponseBody
	public List<MtrqplanVO> selectMtrqplanDetails(@RequestParam String id) {
		System.out.println("\n[MtrqplanController.java] selectMtrqplanDetails - mtrqPlanNo: " + id + "\n");
		List<MtrqplanVO> list = mtrqplanService.selectMtrqplanDetails(id);
		return list;
	}
}
