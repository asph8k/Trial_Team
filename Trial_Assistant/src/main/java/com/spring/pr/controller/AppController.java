package com.spring.pr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pr.app.service.IAppService;
import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.util.PageCreator;
import com.spring.pr.util.SearchVO;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private IAppService service;
	
	//등재 신청자 목록 페이지 요청 처리
	@GetMapping("/appList")
	public String AppList(Model model, SearchVO search, @RequestParam("page") int page) {
		System.out.println("등재 신청자 목록 페이지 요청 들어옴!");
		//model.addAttribute("AppList", service.getAppList());
		System.out.println("뷰에서 넘어온 검색 입력 값:" + search);
		
		search.setPageNum(page);
		List<TotalApplierVO> list = service.getAppList(search);
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		pc.setArticleTotalCount(service.getAppTotal(search));
		model.addAttribute("AppList", list);
		model.addAttribute("pc", pc);
		
		return "/app/appList";
	}

	//등재 신청자 통번역인 상세보기 요청 처리
	@GetMapping("/appDetailTotalTras/{AppNum}")
	public String AppDetailTotalTras(@PathVariable int AppNum,  Model model) {
		System.out.println(service.getTsAppContent(AppNum) + "서비스에서 넘어온 값");
		System.out.println("등재 신청자 통번역인 상세보기 요청 들어옴!");
		model.addAttribute("AppTotalTrasDet", service.getTsAppContent(AppNum));
		return "/app/appDetailTotalTras";
	}
	
	//등재 신청자 일반조력자 상세보기 요청 처리
	@GetMapping("/appDetailNormal/{AppNum}")
	public String AppDetailNormal(@PathVariable int AppNum, Model model) {
		System.out.println(service.getGhAppContent(AppNum) + "서비스에서 넘어온 값");
		System.out.println("등재 신청자 일반조력자 상세보기 요청 들어옴!");
		model.addAttribute("AppGhDet", service.getGhAppContent(AppNum));
		return "/app/appDetailNormal";
	}
	
	//등재 신청자 기관추천조력자 상세보기 요청 처리
	@GetMapping("/appDetailInsRecom/{AppNum}")
	public String AppDetailInsRecom(@PathVariable int AppNum, Model model) {
		System.out.println("등재 신청자 기관추천조력자 상세보기 요청 들어옴!");
		model.addAttribute("AppRecomDet", service.getInsttAppContent(AppNum));
		return "/app/appDetailInsRecom";
	}
	
	//등재 신청사 통번역인 수정 페이지 요청 처리
	@GetMapping("/appUpdateTotalTras/{AppNum}")
	public String AppUpdateTotalTras(@PathVariable int AppNum, Model model) {
		System.out.println("등재 신청자 통번역인 수정 페이지 요청 들어옴!");
		model.addAttribute("AppTotalTrasUpdt", service.getTsAppContent(AppNum));
		return "/app/appUpdateTotalTras";
	}
	
	//등재 신청자 통번역인 수정 요청 처리
	@PostMapping("/appUpdateTotalTras")
	public String AppUpdateTotalTras(TsVO tvo) {
		System.out.println("화면에서 수정된 값 받기" + tvo);
		System.out.println("등재 신청자 통번역인 수정 요청 들어옴!");
		service.updateTsApp(tvo);
		return "redirect:/app/appList?page=1&cpp=10";
	}
		
	//등재 신청자 일반조력자 수정 페이지 요청 처리
	@GetMapping("/appUpdateNormal/{AppNum}")
	public String AppUpdateNormal(@PathVariable int AppNum, Model model) {
		System.out.println("등재 신청자 일반조력자 수정 페이지 요청 들어옴!");
		model.addAttribute("AppGhUpdt", service.getGhAppContent(AppNum));
		return "/app/appUpdateNormal";
	}
	
	//등재 신청자 일반조력자 수정 요청 처리
	@PostMapping("/appUpdateNormal")
	public String AppUpdateNormal(GhVO gvo) {
		System.out.println("화면에서 수정된 값 받기" + gvo);
		System.out.println("등재 신청자 일반조력자 수정 요청 들어옴!");
		service.updateGhApp(gvo);
		return "redirect:/app/appList?page=1&cpp=10";
	}
	
	//등재 신청자 기관추천조력자 수정 페이지 이동 요청 처리
	@GetMapping("/appUpdateInsRecom/{AppNum}")
	public String AppUpdateRecom(@PathVariable int AppNum, Model model) {
		System.out.println("등재 신청자 기관추천조력자 수정 요청 들어옴!");
		model.addAttribute("AppRcUpdt", service.getInsttAppContent(AppNum));
		return "/app/appUpdateInsRecom";
	}
	
	//등재 신청자 기관추천조력자 수정 요청 처리
	@PostMapping("/appUpdateInsRecom")
	public String AppUpdateRecom(InsttVO isvo) {
		System.out.println("화면에서 수정된 값 받기" + isvo);
		System.out.println("등재 신청자 기관추천조력자 수정 요청 들어옴!");
		service.updateInsttApp(isvo);
		return "redirect:/app/appList?page=1&cpp=10";
	}
	
	//등재 신청자 정보 삭제 요청 처리
	@PostMapping("/appDelete/{AppNum}")
	public String AppDelete(@PathVariable int AppNum) {
		System.out.println("등재 신청자 삭제 요청 들어옴!");
		service.deleteApp(AppNum);
		return "redirect:/app/appList?page=1&cpp=10";
	}
	
}
