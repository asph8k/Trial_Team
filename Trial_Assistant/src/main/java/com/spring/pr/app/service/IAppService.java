package com.spring.pr.app.service;

import java.util.List;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.util.PageVO;
import com.spring.pr.util.SearchVO;

public interface IAppService {
	
	//등재 신청자 목록
	//List<TotalApplierVO> getAppList();
	List<TotalApplierVO> getAppList(SearchVO search);
	
	//총 등재 신청자
	int getAppTotal(PageVO paging);
	
	//등재 신청자 상세보기(일반조력자)
	GhVO getGhAppContent(int AppNum);
	
	//등재 신청자 상세보기(통번역인)
	TsVO getTsAppContent(int AppNum);
	
	//등재 신청자 상세보기(기관추천조력자)
	InsttVO getInsttAppContent(int AppNum);
	
	//등재 신청자 수정(일반조력자)
	void updateGhApp(GhVO gvo);
	
	//등재 신청자 수정(통번역인)
	void updateTsApp(TsVO tvo);
	
	//등재 신청자 수정(기관추천조력자)
	void updateInsttApp(InsttVO ivo);
	
	//등재 신청자 삭제
	void deleteApp(int AppNum);
	
}
