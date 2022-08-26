package com.spring.pr.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.app.mapper.IAppMapper;
import com.spring.pr.command.AppVO;
import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.util.PageVO;
import com.spring.pr.util.SearchVO;

@Service
public class AppService implements IAppService {
	
	@Autowired
	private IAppMapper mapper;
/*
	@Override
	public List<TotalApplierVO> getAppList() {
		return mapper.getAppList();
	}
*/	
	@Override
	public List<TotalApplierVO> getAppList(SearchVO search) {
		List<TotalApplierVO> list = mapper.getAppList(search);
		return list;
	}
	
	@Override
	public int getAppTotal(PageVO paging) {
		return mapper.getAppTotal(paging);
	}
 
	@Override
	public AppVO getGhAppContent(int AppNumSeq) {
		System.out.println(mapper.getGhAppContent(AppNumSeq) + "매퍼에서 넘어온 값");
		return mapper.getGhAppContent(AppNumSeq);
	}

	@Override
	public AppVO getTsAppContent(int AppNumSeq) {
		return mapper.getTsAppContent(AppNumSeq);
	}

	@Override
	public AppVO getInsttAppContent(int AppNumSeq) {
		return mapper.getInsttAppContent(AppNumSeq);
	}

	@Override
	public void updateGhApp(GhVO gvo) {
		mapper.updateGhApp(gvo);
	}

	@Override
	public void updateTsApp(TsVO tvo) {
		System.out.println("컨트롤러에서 넘어온 수정" + tvo);
		mapper.updateTsApp(tvo);
	}

	@Override
	public void updateInsttApp(InsttVO ivo) {
		mapper.updateInsttApp(ivo);
	}

	@Override
	public void deleteApp(int AppNumSeq) {
		mapper.deleteApp(AppNumSeq);
	}

}
