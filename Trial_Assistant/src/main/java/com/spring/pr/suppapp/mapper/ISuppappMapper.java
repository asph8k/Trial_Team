package com.spring.pr.suppapp.mapper;

import java.util.List;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.util.PageVO;
import com.spring.pr.util.SearchVO;

public interface ISuppappMapper {

	//보완 요청자 목록
	List<TotalApplierVO> getSuppappList(SearchVO search);
	
	//총 보완 요청자 수
	int getSuppappTotal(PageVO paging);
	
	//보완 요청자 상세보기(일반조력자)
	GhVO getGhSuppappContent(int AppNum);
	
	//보완 요청자 상세보기(통번역인)
	TsVO getTsSuppappContent(int AppNum);
	
	//보완 요청자 상세보기(기관추천조력자)
	InsttVO getInsttSuppappContent(int AppNum);
	
	//보완 요청자 수정(일반조력자)
	void updateGhSuppapp(GhVO gvo);
	
	//보완 요청자 수정(통번역인)
	void updateTsSuppapp(TsVO tvo);
	
	//보완 요청자 수정(기관추천조력자)
	void updateInsttSuppapp(InsttVO ivo);
	
	//보완 요청자 삭제
	void deleteSuppapp(int AppNum);

	
}
