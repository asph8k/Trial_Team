package com.spring.pr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.insapp.service.IInsappService;
import com.spring.pr.util.PageCreator;
import com.spring.pr.util.SearchVO;

@Controller
@RequestMapping("/insapp")
public class InsappController {

	@Autowired
	private IInsappService service;
	
	// 기관 신청자 목록 페이지 요청 처리
	@GetMapping("/insappList")
	public String InsappList(Model model, SearchVO search, @RequestParam("page") int page) {
		System.out.println("기관 신청자 목록 페이지 요청이 들어옴!");
		
		search.setPageNum(page);
		List<TotalApplierVO> list = service.getInsappList(search);
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		pc.setArticleTotalCount(service.getInsappTotal(search));
		model.addAttribute("insapplist", list);
		model.addAttribute("pc", pc);
		
		return "/insapp/insappList";
	}
	
	// 기관 신청자 상세보기 요청 처리
	@GetMapping("/insappDetail")
	public void InsappDetail() {
		System.out.println("기관 신청자 상세보기 요청이 들어옴!");
	}
	
	// 기관 신청자 수정 페이지 요청 처리
	@GetMapping("/insappUpdate")
	public void InsappUpdate() {
		System.out.println("기관 신청자 수정 요청이 들어옴!");
	}
	
}
