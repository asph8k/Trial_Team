package com.spring.pr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.suppapp.service.ISuppappService;
import com.spring.pr.util.PageCreator;
import com.spring.pr.util.PageVO;

@Controller
@RequestMapping("/suppapp")
public class SuppappController {
	
	@Autowired
	private ISuppappService service;
	
	//보완 요청자 목록 요청 처리
	@GetMapping("/suppappList")
	public String SuppappList(Model model, PageVO page) {
		System.out.println("보완 요청자 목록 요청이 들어옴!");
		model.addAttribute("SupappList", service.getSupappList(page));
		
		PageCreator pc = new PageCreator();
		pc.setPaging(page);
		pc.setArticleTotalCount(service.getSupappTotal(page));
		model.addAttribute("pc", pc);
		
		return "/suppapp/suppappList";
	}
	
	//보완 요청자 통번역인 상세보기 요청 처리
	@GetMapping("/suppappDetailTotalTras/{AppNum}")
	public String suppappDetailTotalTras(@PathVariable int AppNum, Model model) {
		System.out.println("보완 요청자 통번역인 상세보기 요청 들어옴!");
		model.addAttribute("SuppappTotalDet", service.getTsSupappContent(AppNum));
		return "/suppapp/suppappDetailTotalTras";
	}
	
	//보완 요청자 일반조력자 상세보기 요청 처리
	@GetMapping("/suppappDetailNormal/{AppNum}")
	public String suppappDetailNormal(@PathVariable int AppNum, Model model) {
		System.out.println("보완 요청자 일반조력자 상세보기 요청 들어옴!");
		model.addAttribute("SuppappGhDet", service.getGhSupappContent(AppNum));
		return "/suppapp/suppappDetailNormal";
	}
	
	//보완 요청자 기관추천조력자 상세보기 요청 처리
	@GetMapping("/suppappDetailInsRecom/{AppNum}")
	public String suppappDetailInsRecom(@PathVariable int AppNum, Model model) {
		System.out.println("보완 요청자 기관추천조력자 상세보기 요청 들어옴!");
		model.addAttribute("SuppappRecomDet", service.getInsttSupappContent(AppNum));
		return "/suppapp/suppappDetailInsRecom";
	}
	
	//보완 요청자 통번역인 수정 페이지 요청 처리
	@GetMapping("/suppappUpdateTotalTras/{AppNum}")
	public String suppappUpdateTotalTras(@PathVariable int AppNum, Model model) {
		System.out.println("보완 요청자 통번역인 수정 요청 들어옴!");
		model.addAttribute("SuppappTsUpdt", service.getTsSupappContent(AppNum));
		return "/suppapp/suppappUpdateTotalTras";
	}
	
	//보완 요청자 통번역인 수정 요청 처리
	@PostMapping("/suppappUpdateTotalTras")
	public String suppappUpdateTotalTras(TsVO tvo) {
		System.out.println("뷰에서 넘어온 값:" + tvo);
		System.out.println("보완 요청자 통번역인 수정 요청 들어옴!");
		service.updateTsSupapp(tvo);
		return "redirect:/suppapp/suppappList?page=1&cpp=10";
	}
	
	//보완 요청자 일반조력자 수정 페이지 요청 처리
	@GetMapping("/suppappUpdateNormal/{AppNum}")
	public String suppappUpdateNormal(@PathVariable int AppNum, Model model) {
		System.out.println("보완 요청자 일반조력자 수정 요청 들어옴!");
		model.addAttribute("SuppappGhUpdt", service.getGhSupappContent(AppNum));
		return "/suppapp/suppappUpdateNormal";
	}
	
	//보완 요청자 일반조력자 수정 요청 처리
	@PostMapping("/suppappUpdateNormal")
	public String suppappUpdateNormal(GhVO gvo) {
		System.out.println("GH뷰에서 넘어온 값:" + gvo);
		System.out.println("보완 요청자 일반조력자 수정 요청 들어옴!");
		service.updateGhSupapp(gvo);
		return "redirect:/suppapp/suppappList?page=1&cpp=10";
	}
	
	//보완 요청자 기관추천조력자 수정 페이지 요청 처리
	@GetMapping("/suppappUpdateInsRecom/{AppNum}")
	public String AppUpdateRecom(@PathVariable int AppNum, Model model) {
		System.out.println("보완 요청자 기관추천조력자 수정 요청 들어옴!");
		model.addAttribute("SuppappRecomUpdt", service.getInsttSupappContent(AppNum));
		return "/suppapp/suppappUpdateInsRecom";
	}
	
	//보완 요청자 기관추천조력자 수정 요청 처리
	@PostMapping("/suppappUpdateInsRecom")
	public String AppUpdateRecom(InsttVO isvo) {
		System.out.println("보완 요청자 기관추천조력자 수정 요청 들어옴!");
		service.updateInsttSupapp(isvo);
		return "redirect:/suppapp/suppappList?page=1&cpp=10";
	}
	
	//보완 요청자 삭제 요청 처리
	@PostMapping("/suppappDelete/{AppNum}")
	public String SuppappDelete(@PathVariable int AppNum) {
		System.out.println("보완 요청자 삭제 요청 들어옴!");
		service.deleteSupapp(AppNum);
		return "redirect:/suppapp/suppappList?page=1&cpp=10";
	}

}
