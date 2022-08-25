package com.spring.pr.suppapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.suppapp.mapper.ISuppappMapper;
import com.spring.pr.util.PageVO;
import com.spring.pr.util.SearchVO;

@Service
public class SuppappService implements ISuppappService {

	@Autowired
	private ISuppappMapper mapper;
	
	@Override
	public List<TotalApplierVO> getSupappList(SearchVO search) {
		List<TotalApplierVO> list = mapper.getSuppappList(search);
		return list;
	}
	
	@Override
	public int getSupappTotal(PageVO paging) {
		return mapper.getSuppappTotal(paging);
	}

	@Override
	public GhVO getGhSupappContent(int AppNum) {
		return mapper.getGhSuppappContent(AppNum);
	}

	@Override
	public TsVO getTsSupappContent(int AppNum) {
		return mapper.getTsSuppappContent(AppNum);
	}

	@Override
	public InsttVO getInsttSupappContent(int AppNum) {
		return mapper.getInsttSuppappContent(AppNum);
	}

	@Override
	public void updateGhSupapp(GhVO gvo) {
		mapper.updateGhSuppapp(gvo);
	}

	@Override
	public void updateTsSupapp(TsVO tvo) {
		mapper.updateTsSuppapp(tvo);
	}

	@Override
	public void updateInsttSupapp(InsttVO ivo) {
		mapper.updateInsttSuppapp(ivo);
	}

	@Override
	public void deleteSupapp(int AppNum) {
		mapper.deleteSuppapp(AppNum);
	}

}
