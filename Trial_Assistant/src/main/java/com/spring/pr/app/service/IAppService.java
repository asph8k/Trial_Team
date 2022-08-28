package com.spring.pr.app.service;

import java.util.List;

import com.spring.pr.command.AppVO;
import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.util.PageVO;

public interface IAppService {
	
	//등재 신청자 목록
	/*
 	Announcement테이블에서 공고번호를 받아서 TotalApplier테이블에 모든 데이터를
 	나타내 주기 위한 메서드
	*/
	List<TotalApplierVO> getAppList(PageVO page);
	
	//총 등재 신청자
	//페이징을 위해 TotalApplier테이블에서 총 몇개의 데이터가 있는지 총 개수를 구하는 메서드
	int getAppTotal(PageVO paging);
	
	//등재 신청자 상세보기(일반조력자)
	//Announcement테이블에서 공고번호를 받아와서 Gh테이블에서 일반조력자에 대한 상세보기를 위한 메서드
	AppVO getGhAppContent(int AppNumSeq);
	
	//등재 신청자 상세보기(통번역인)
	//Announcement테이블에서 공고번호를 받아와서 Ts테이블에서 통번역인에 대한 상세보기를 위한 메서드
	AppVO getTsAppContent(int AppNumSeq);
	
	//등재 신청자 상세보기(기관추천조력자)
	//Announcement테이블에서 공고번호를 받아와서 Instt테이블에서 기관추천조력자에 대한 상세보기를 위한 메서드
	AppVO getInsttAppContent(int AppNumSeq);
	
	//등재 신청자 수정(일반조력자)
 	//일반조력자 수정에서 신청자메모를 수정하게 되면 Gh테이블에서도 메모가 수정하기 위한 메서드
	void updateGhApp(GhVO gvo);
	
	//등재 신청자 수정(통번역인)
 	//통번역인 수정에서 신청자메모를 수정하게 되면 Ts테이블에서도 메모가 수정하기 위한 메서드
	void updateTsApp(TsVO tvo);
	
	//등재 신청자 수정(기관추천조력자)
 	//기관추천조력자 수정에서 신청자메모를 수정하게 되면 Instt테이블에서도 메모가 수정하기 위한 메서드
	void updateInsttApp(InsttVO ivo);
	
	//등재 신청자 삭제
	//신청번호를 받아 해당 정보를 삭제하는 메서드
	void deleteApp(int AppNumSeq);
	
//------------------------------부적격 처리

	//통번역인 부적격 처리
	boolean insertTsUnq(AppVO avo);
	
	//일반조력자 부적격 처리
	boolean insertGhUnq(AppVO avo);
	
	//기관추천조력자 부적격 처리
	boolean insertInsttUnq(AppVO avo);
	
}
