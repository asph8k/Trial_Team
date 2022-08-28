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

@Service
public class AppService implements IAppService {
	
	@Autowired
	private IAppMapper mapper;
	
	/*
 	컨트롤러에서 넘어온 요청을 받는 TotalApplierVO타입인 getAppList메서드는 다시 한번 mapper에게 전체신청자에 대한 리스트를
 	가져오기 위한 요청을 보낸다. 이때 페이징 작업도 하기 위해 PageVO타입인 page변수 또한 같이 mapper에게 요청을 보낸다.
	*/
	@Override
	public List<TotalApplierVO> getAppList(PageVO page) {
		List<TotalApplierVO> list = mapper.getAppList(page);
		return list;
	}
	
	/*
	페이징을 위해 컨트롤러에서 넘어온 요청을 받는 int타입인 getAppTotal메서드는
	mapper에게 pageVO타입은 paging변수를 넘겨주며 getAppTotal메서드를 호출하여 전체신청자 총 개수 요청을 보낸다.
	*/
	@Override
	public int getAppTotal(PageVO paging) {
		return mapper.getAppTotal(paging);
	}
 
	/*
	컨트롤러에서 넘어온 공고번호를 받아 AppVO타입이며 공고번호를 매개변수로 받는 getGhAppContent메서드를 호출하여
	mapper에게 다시한번 공고번호를 받는 getGhAppContent메서드를 호출하여 일반조력자 상세보 요청을 보낸다.
	*/
	@Override
	public AppVO getGhAppContent(int AppNumSeq) {
		return mapper.getGhAppContent(AppNumSeq);
	}

	/*
	컨트롤러에서 넘어온 공고번호를 받아 AppVO타입이며 공고번호를 매개변수로 받는 getTsAppContent메서드를 호출하여
	mapper에게 다시한번 공고번호를 받는 getTsAppContent메서드를 호출하여 통번역인 상세보기 요청을 보낸다.
	*/
	@Override
	public AppVO getTsAppContent(int AppNumSeq) {
		return mapper.getTsAppContent(AppNumSeq);
	}

	/*
	컨트롤러에서 넘어온 공고번호를 받아 AppVO타입이며 공고번호를 매개변수로 받는 getInsttAppContent메서드를 호출하여
	mapper에게 다시한번 공고번호를 받는 getInsttAppContent메서드를 호출하여 기관추천조력자 상세보기 요청을 보낸다.
	*/
	@Override
	public AppVO getInsttAppContent(int AppNumSeq) {
		return mapper.getInsttAppContent(AppNumSeq);
	}

	/*
 	컨트롤러에서 넘어온 일반조력자 수청 요청을 GhVO타입인 gvo매개변수를 가지고 있는 updateGhApp메서드를 호출하여
 	mapper에게 다시한번 gvo를 넘겨주며 updateGhApp란 메서드를 호출하여 일반조력자 수정 요청을 보낸다.
	*/
	@Override
	public void updateGhApp(GhVO gvo) {
		mapper.updateGhApp(gvo);
	}

	/*
 	컨트롤러에서 넘어온 통번역인 수청 요청을 TsVO타입인 tvo매개변수를 가지고 있는 updateTsApp메서드를 호출하여
 	mapper에게 다시한번 tvo를 넘겨주며 updateTsApp란 메서드를 호출하여 통번역인 수정 요청을 보낸다.
	*/
	@Override
	public void updateTsApp(TsVO tvo) {
		mapper.updateTsApp(tvo);
	}

	/*
 	컨트롤러에서 넘어온 기관추천조력자 수청 요청을 InsttVO타입인 ivo매개변수를 가지고 있는 updateInsttApp메서드를 호출하여
 	mapper에게 다시한번 ivo를 넘겨주며 updateInsttApp란 메서드를 호출하여 기관추천조력자 수청 요청을 보낸다.
	*/
	@Override
	public void updateInsttApp(InsttVO ivo) {
		mapper.updateInsttApp(ivo);
	}

	/*
	컨트롤러에서 공고번호와 함께 넘어온 요청을 받아 
	deleteApp란 메서드를 호출하여 매개변수로 공고번호를 받아 mapper에게 deleteApp란 메서드를 호출하여 공고번호를 넘겨주며 삭제 요청을 보낸다.
	*/
	@Override
	public void deleteApp(int AppNumSeq) {
		mapper.deleteApp(AppNumSeq);
	}

	/*---------------부적격 처리*/
	
	@Override
	public boolean insertTsUnq(AppVO avo) {
		return mapper.insertTsUnq(avo);
	}

	@Override
	public boolean insertGhUnq(AppVO avo) {
		return mapper.insertGhUnq(avo);
	}

	@Override
	public boolean insertInsttUnq(AppVO avo) {
		return mapper.insertInsttUnq(avo);
	}

}
