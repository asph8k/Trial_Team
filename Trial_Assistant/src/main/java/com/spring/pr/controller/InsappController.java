package com.spring.pr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.insapp.service.IInsappService;
import com.spring.pr.util.PageCreator;
import com.spring.pr.util.PageVO;

@Controller
@RequestMapping("/insapp")
public class InsappController {

	@Autowired
	private IInsappService service;
	
	// 기관 신청자 목록 페이지 요청 처리
	@GetMapping("/insappList")
	public String InsappList(Model model, PageVO page) {
		System.out.println("기관 신청자 목록 페이지 요청이 들어옴!");
		model.addAttribute("insapplist", service.getInsappList(page));
		
		PageCreator pc = new PageCreator();
		pc.setPaging(page);
		pc.setArticleTotalCount(service.getInsappTotal(page));
		model.addAttribute("pc", pc);
		
		return "/insapp/insappList";
	}
	
	// 기관 신청자 상세보기 요청 처리
	@GetMapping("/insappDetail/{ANum}")
	public String InsappDetail(@PathVariable int ANum, Model model) {
		System.out.println("기관 신청자 상세보기 요청이 들어옴!");
		model.addAttribute("insappDet", service.getInsappContent(ANum));
		return "/insapp/insappDetail";
	}
	
	// 기관 신청자 수정 페이지 요청 처리
	@GetMapping("/insappUpdate/{ANum}")
	public String InsappUpdate(@PathVariable int ANum, Model model, TotalApplierVO tvo) {
		System.out.println("기관 신청자 수정 페이지 요청이 들어옴!");
		model.addAttribute("insappUpdt", service.getInsappContent(ANum));
		return "/insapp/insappUpdate";
	}
	
	//기관 신청자 수정 요청 처리
	@PostMapping("/insappUpdate")
	public String InsappUpdate(TotalApplierVO tvo) {
		System.out.println("화면에서 수정된 값:" + tvo);
		System.out.println("기관 신청자 수정 요청이 들어옴!");
		service.updateInsapp(tvo);
		return "redirect:/insapp/insappList?page=1&cpp=10";
	}
	
	//기관 신청자 삭제 요청 처리
	@PostMapping("/insappDelete/{ANum}")
	public String InsappDelete(@PathVariable int ANum) {
		System.out.println("기관 신청자 삭제 요청 들어옴!");
		service.deleteInsapp(ANum);
		return "redirect:/insapp/insappList?page=1&cpp=10";
	}
 	
}
