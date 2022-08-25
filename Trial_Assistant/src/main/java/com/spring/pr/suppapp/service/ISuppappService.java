package com.spring.pr.suppapp.service;

import java.util.List;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.util.PageVO;
import com.spring.pr.util.SearchVO;

public interface ISuppappService {

	//보완 요청자 목록
	List<TotalApplierVO> getSupappList(SearchVO search);
	
	//총 등재 신청자
	int getSupappTotal(PageVO paging);
	
	//보완 요청자 상세보기(일반조력자)
	GhVO getGhSupappContent(int AppNum);
	
	//보완 요청자 상세보기(통번역인)
	TsVO getTsSupappContent(int AppNum);
	
	//보완 요청자 상세보기(기관추천조력자)
	InsttVO getInsttSupappContent(int AppNum);
	
	//보완 요청자 수정(일반조력자)
	void updateGhSupapp(GhVO gvo);
	
	//보완 요청자 수정(통번역인)
	void updateTsSupapp(TsVO tvo);
	
	//보완 요청자 수정(기관추천조력자)
	void updateInsttSupapp(InsttVO ivo);
	
	//보완 요청자 삭제
	void deleteSupapp(int AppNum);
	
}
