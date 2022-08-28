package com.spring.pr.insapp.service;

import java.util.List;

import com.spring.pr.command.InsappVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.util.PageVO;

public interface IInsappService {

	//기관 신청자 정보 목록
	List<TotalApplierVO> getInsappList(PageVO page);
	
	//총 기관 신청자 목록 수
	int getInsappTotal(PageVO paging);
	
	//기관 신청자 상세 보기
	TotalApplierVO getInsappContent(int ANum);
	
	//기관 신청자 수정
	void updateInsapp(TotalApplierVO tvo);
	
	//기관 신청자 삭제
	void deleteInsapp(int AppNum);
}
