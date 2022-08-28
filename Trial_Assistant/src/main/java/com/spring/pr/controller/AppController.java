package com.spring.pr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.pr.app.service.IAppService;
import com.spring.pr.command.AppVO;
import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.util.PageCreator;
import com.spring.pr.util.PageVO;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private IAppService service;
	
	/*
	AppList란 메서드를 준비하여 페이징처리를 하기 위해 pageVO를 선언하고 model에 담아 화면에 뿌려주기 위해 model 선언.
	appList.jsp한테 service에서 얻어온 값을 뿌려주기 위해 model에 담고 그걸 AppList로 이름을 붙힘.
	페이징 작업을 하기 위해 PageCreator객체를 생성하고 전체신청자 리스트 총합 개수를 service에서 받아옴.
	그리고 반환된 pc를 모델에 담아 pc란 이름으로 보내줌.
	*/
	//등재 신청자 목록 페이지 요청 처리
	@GetMapping("/appList")
	public String AppList(Model model, PageVO page) {
		System.out.println("등재 신청자 목록 페이지 요청 들어옴!");
		model.addAttribute("AppList", service.getAppList(page));
		
		PageCreator pc = new PageCreator();
		pc.setPaging(page);
		pc.setArticleTotalCount(service.getAppTotal(page));
		model.addAttribute("pc", pc);
		
		return "/app/appList";
	}

	/*
	/appDetailTotalTras란 요청과 함께 공고번호도 같이 묻혀오면 
	AppDetailTotalTras란 메서드가 공고번호를 매개변수로 받는다.
	받아온 공고번호를 통해 service에게 공고번호를 주면서 getTsAppContent란 메서드를 호출하여 
	통번역인에 대한 상세내용들을 받아와 AppTotalTrasDet란 모델 객체에 담아 뷰에 뿌려준다. 
	*/
	//등재 신청자 통번역인 상세보기 요청 처리
	@GetMapping("/appDetailTotalTras/{AppNumSeq}")
	public String AppDetailTotalTras(@PathVariable int AppNumSeq,  Model model) {
		System.out.println(service.getTsAppContent(AppNumSeq) + "서비스에서 넘어온 값");
		System.out.println("등재 신청자 통번역인 상세보기 요청 들어옴!");
		model.addAttribute("AppTotalTrasDet", service.getTsAppContent(AppNumSeq));
		return "/app/appDetailTotalTras";
	}
	
	/*
	/appDetailNormal란 요청과 함께 공고번호도 같이 묻혀오면 
	AppDetailNormal란 메서드가 공고번호를 매개변수로 받는다.
	받아온 공고번호를 통해 service에게 공고번호를 주면서 getGhAppContent란 메서드를 호출하여 
	통번역인에 대한 상세내용들을 받아와 AppGhDet란 모델 객체에 담아 뷰에 뿌려준다. 
	*/
	//등재 신청자 일반조력자 상세보기 요청 처리
	@GetMapping("/appDetailNormal/{AppNumSeq}")
	public String AppDetailNormal(@PathVariable int AppNumSeq, Model model) {
		System.out.println(service.getGhAppContent(AppNumSeq) + "서비스에서 넘어온 값");
		System.out.println("등재 신청자 일반조력자 상세보기 요청 들어옴!");
		model.addAttribute("AppGhDet", service.getGhAppContent(AppNumSeq));
		return "/app/appDetailNormal";
	}
	
	/*
	/appDetailInsRecom란 요청과 함께 공고번호도 같이 묻혀오면 
	AppDetailInsRecom란 메서드가 공고번호를 매개변수로 받는다.
	받아온 공고번호를 통해 service에게 공고번호를 주면서 getInsttAppContent란 메서드를 호출하여 
	통번역인에 대한 상세내용들을 받아와 AppRecomDet란 모델 객체에 담아 뷰에 뿌려준다. 
	*/
	//등재 신청자 기관추천조력자 상세보기 요청 처리
	@GetMapping("/appDetailInsRecom/{AppNumSeq}")
	public String AppDetailInsRecom(@PathVariable int AppNumSeq, Model model) {
		System.out.println("등재 신청자 기관추천조력자 상세보기 요청 들어옴!");
		model.addAttribute("AppRecomDet", service.getInsttAppContent(AppNumSeq));
		return "/app/appDetailInsRecom";
	}
	
	/*
	/appUpdateTotalTras란 요청과 함께 공고번호도 같이 묻혀오면
	AppUpdateTotalTras란 메서드가 공고번호를 매개변수로 받는다.
	받아온 공고번호를 통해 service에게 공고번호를 주면서 다시 한번 getTsAppContent란 메서드를 호출하여
	통번역인에 대한 상세내용을 받아와 AppTotalTrasUpdt란 모델 객체에 담아 뷰에 뿌려준다.
	*/
	//등재 신청사 통번역인 수정 페이지 요청 처리
	@GetMapping("/appUpdateTotalTras/{AppNumSeq}")
	public String AppUpdateTotalTras(@PathVariable int AppNumSeq, Model model) {
		System.out.println("등재 신청자 통번역인 수정 페이지 요청 들어옴!");
		model.addAttribute("AppTotalTrasUpdt", service.getTsAppContent(AppNumSeq));
		return "/app/appUpdateTotalTras";
	}
	
	/*
	/appUpdateTotalTras란 요청이 들어오면 AppUpdateTotalTras란 메서드를 호출하여 TsVO타입의 tvo 매개변수를 선언해서
	service에게 updateTsApp메서드를 호출하여 TsVO타입인 tvo를 넘겨주어 수정 요청을 보낸다.
	그리고 /app/appList로 다시 돌아간다.
	*/
	//등재 신청자 통번역인 수정 요청 처리
	@PostMapping("/appUpdateTotalTras")
	public String AppUpdateTotalTras(TsVO tvo) {
		System.out.println("등재 신청자 통번역인 수정 요청 들어옴!");
		service.updateTsApp(tvo);
		return "redirect:/app/appList";
	}
	
	/*
	/appUpdateNormal란 요청과 함께 공고번호도 같이 묻혀오면
	AppUpdateNormal란 메서드가 공고번호를 매개변수로 받는다.
	받아온 공고번호를 통해 service에게 공고번호를 주면서 다시 한번 getGhAppContent란 메서드를 호출하여
	통번역인에 대한 상세내용을 받아와 AppGhUpdt란 모델 객체에 담아 뷰에 뿌려준다.
	*/
	//등재 신청자 일반조력자 수정 페이지 요청 처리
	@GetMapping("/appUpdateNormal/{AppNumSeq}")
	public String AppUpdateNormal(@PathVariable int AppNumSeq, Model model) {
		System.out.println("등재 신청자 일반조력자 수정 페이지 요청 들어옴!");
		model.addAttribute("AppGhUpdt", service.getGhAppContent(AppNumSeq));
		return "/app/appUpdateNormal";
	}
	
	/*
	/appUpdateNormal란 요청이 들어오면 AppUpdateNormal란 메서드를 호출하여 GhVO타입의 gvo 매개변수를 선언해서
	service에게 updateGhApp메서드를 호출하여 GhVO타입인 gvo를 넘겨주어 수정 요청을 보낸다.
	그리고 /app/appList로 다시 돌아간다.
	*/
	//등재 신청자 일반조력자 수정 요청 처리
	@PostMapping("/appUpdateNormal")
	public String AppUpdateNormal(GhVO gvo) {
		System.out.println("등재 신청자 일반조력자 수정 요청 들어옴!");
		service.updateGhApp(gvo);
		return "redirect:/app/appList";
	}
	
	/*
	/appUpdateInsRecom란 요청과 함께 공고번호도 같이 묻혀오면
	AppUpdateRecom란 메서드가 공고번호를 매개변수로 받는다.
	받아온 공고번호를 통해 service에게 공고번호를 주면서 다시 한번 getInsttAppContent란 메서드를 호출하여
	통번역인에 대한 상세내용을 받아와 AppRcUpdt란 모델 객체에 담아 뷰에 뿌려준다.
	*/
	//등재 신청자 기관추천조력자 수정 페이지 이동 요청 처리
	@GetMapping("/appUpdateInsRecom/{AppNumSeq}")
	public String AppUpdateRecom(@PathVariable int AppNumSeq, Model model) {
		System.out.println("등재 신청자 기관추천조력자 수정 요청 들어옴!");
		model.addAttribute("AppRcUpdt", service.getInsttAppContent(AppNumSeq));
		return "/app/appUpdateInsRecom";
	}
	
	/*
	/appUpdateInsRecom란 요청이 들어오면 AppUpdateRecom란 메서드를 호출하여 InsttVO타입의 isvo 매개변수를 선언해서
	service에게 updateInsttApp메서드를 호출하여 InsttVO타입인 isvo를 넘겨주어 수정 요청을 보낸다.
	그리고 /app/appList로 다시 돌아간다.
	*/
	//등재 신청자 기관추천조력자 수정 요청 처리
	@PostMapping("/appUpdateInsRecom")
	public String AppUpdateRecom(InsttVO isvo) {
		System.out.println("등재 신청자 기관추천조력자 수정 요청 들어옴!");
		service.updateInsttApp(isvo);
		return "redirect:/app/appList";
	}
	
	/*
	/appDelete란 요청과 함께 공고번호가 묻혀오면 AppDelete란 메서드를 호출하여
	매개변수로 묻혀온 공고번호를 선언한다.
	service에게 deleteApp란 메서드를 호출하여 공고 번호를 넘겨주어 삭제 요청을 보낸다.
	*/
	//등재 신청자 정보 삭제 요청 처리
	@PostMapping("/appDelete/{AppNumSeq}")
	public String AppDelete(@PathVariable int AppNumSeq) {
		System.out.println("등재 신청자 삭제 요청 들어옴!");
		service.deleteApp(AppNumSeq);
		return "redirect:/app/appList";
	}
	
//---------------------부적격 처리-----------------------
	
	//부적격 처리 요청
	//통번역인에 대한 부적격 처리
	@PostMapping("/appTransUnq")
	public String AppTsUnq(AppVO avo) {
		System.out.println("뷰에서 넘어온 값:" + avo);
		System.out.println("통번역인 부적격자 처리 요청 들어옴!");
		service.insertTsUnq(avo);
		return "redirect:/app/appList";
	}
	
	//일반조력자에 대한 부적격 처리
	@PostMapping("/appNormalUnq")
	public String AppNormalUnq(AppVO avo) {
		System.out.println("일반조력자 부적격자 처리 요청 들어옴!");
		service.insertGhUnq(avo);
		return "redirect:/app/appList";
	}
	
	//기관추천조력자에 대한 부적격 처리
	@PostMapping("/appInsttUnq")
	public String AppInsttUnq(AppVO avo) {
		System.out.println("기관추천조력자 부적격자 처리 요청 들어옴!");
		service.insertInsttUnq(avo);
		return "redirect:/app/appList";
	}
	
}
