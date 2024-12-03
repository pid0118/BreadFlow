package com.breadflow.app.mtrqplan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.breadflow.app.mtrqplan.service.MtrqplanService;
import com.breadflow.app.mtrqplan.service.MtrqplanVO;
import com.breadflow.app.prdtplan.service.PrdtplanService;
import com.breadflow.app.prdtplan.service.PrdtplanVO;

import jakarta.servlet.http.HttpSession;

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
	
	@PostMapping("updateMtrqplanDetailForProgress")
	@ResponseBody
	public int updateMtrqplanDetailForProgress(@RequestBody MtrqplanVO mtrqplanVO) {
		int result = mtrqplanService.updateMtrqplanDetailForProgress(mtrqplanVO);
		return result;
	}
	
	
	//== 자재소요계획(공급업체) 페이지에서 사용되는 컨트롤러 ==//
	
	@GetMapping("mtrqplanPrcs")
	public String mtrqpplanPrsc(Model model, HttpSession session) {
		String CompanyNo = (String) session.getAttribute("companyNo");
		List<MtrqplanVO> list = mtrqplanService.selectMtrqplanForCom(CompanyNo);
		model.addAttribute("plans", list);
		return "mtrqplan/mtrqplanPrcs";
	}
	
	
	@GetMapping("selectMtrqplanForForm")
	@ResponseBody
	public MtrqplanVO selectMtrqplanForForm(@RequestParam String id) {
		System.out.println("\n[MtrqplanController.java] selectMtrqplanForForm - id: " + id + "\n");
		MtrqplanVO mVO = mtrqplanService.selectMtrqplanForForm(id);
		return mVO;
	}

	
	@GetMapping("selectMtrqplanDetailForGrid")
	@ResponseBody
	public List<MtrqplanVO> selectMtrqplanDetailForGrid(@RequestParam String id) {
		System.out.println("\n[MtrqplanController.java] selectMtrqplanDetailForGrid - id: " + id + "\n");
		List<MtrqplanVO> list = mtrqplanService.selectMtrqplanDetailForGrid(id);
		return list;
	}
	
	@PostMapping("updateMtrqDetailForProgressToC4")
	@ResponseBody
	public int updateMtrqDetailForProgressToC4(@RequestBody MtrqplanVO mtrqplanVO) {
		System.out.println("\n[PrdtplanController.java] updateMtrqDetailForProgressToC4 - mtrqplanVO: " + mtrqplanVO + "\n");
		int result = mtrqplanService.updateMtrqDetailForProgressToC4(mtrqplanVO);
		return result;
	}
	
	@PostMapping("updateMatqDetailForProgressToC5")
	@ResponseBody
	public int updateMatqDetailForProgressToC5(@RequestBody MtrqplanVO mtrqplanVO) {
		System.out.println("\n[PrdtplanController.java] updateMatqDetailForProgressToC5 - mtrqplanVO: " + mtrqplanVO + "\n");
		int result = mtrqplanService.updateMatqDetailForProgressToC5(mtrqplanVO);
		return result;
	}
	
	@PostMapping("insertInstoreForMtrqplan")
	@ResponseBody
	public int insertInstoreForMtrqplan(@RequestBody List<MtrqplanVO> list, HttpSession session) {
		String writer = (String) session.getAttribute("memNo");
		String company = (String) session.getAttribute("companyNo");
		System.out.println("\n[PrdtplanController.java] insertInstoreForMtrqplan - list: " + list + "\n");
		
		int result = mtrqplanService.insertInstoreForMtrqplan(list, writer, company);
		return result;
	}
}
