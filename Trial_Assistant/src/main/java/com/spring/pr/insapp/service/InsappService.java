package com.spring.pr.insapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pr.command.InsappVO;
import com.spring.pr.command.TotalApplierVO;
import com.spring.pr.insapp.mapper.IInsappMapper;
import com.spring.pr.util.PageVO;

@Service
public class InsappService implements IInsappService {

	@Autowired
	private IInsappMapper mapper;
	
	@Override
	public List<TotalApplierVO> getInsappList(PageVO page) {
		return mapper.getInsappList(page);
	}

	@Override
	public int getInsappTotal(PageVO paging) {
		return mapper.getInsappTotal(paging);
	}

	@Override
	public TotalApplierVO getInsappContent(int ANum) {
		return mapper.getInsappContent(ANum);
	}

	@Override
	public void updateInsapp(TotalApplierVO tvo) {
		mapper.updateInsapp(tvo);
	}

	@Override
	public void deleteInsapp(int AppNum) {
		mapper.deleteInsapp(AppNum);
	}

}
