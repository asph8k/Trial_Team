package com.spring.pr.trial.notice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.pr.command.GhVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.command.TsVO;
import com.spring.pr.suppapp.mapper.ISuppappMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SuppappMapperTest {
	
	@Autowired ISuppappMapper mapper;
/*
	@Test
	public void getListTest() {
		System.out.println(mapper.getSuppappList());
	}
	
	@Test
	public void getTotal() {
		System.out.println(mapper.getSuppappTotal());
	}
	
	@Test 
	public void getInsttContentTest() {
		System.out.println(mapper.getInsttSuppappContent(3));
	}
	
	@Test 
	public void getTsContentTest() {
		System.out.println(mapper.getTsSuppappContent(3));
	}
	
	@Test 
	public void getGhContentTest() {
		System.out.println(mapper.getGhSuppappContent(3));
	}
	
	@Test
	public void updateInsttTest() {
		InsttVO instt = new InsttVO();
		instt.setInsttNum(6);
		instt.setInsttName("수정6");
		instt.setInsttHomeNum("수정");
		instt.setInsttPhoneNum("수정");
		instt.setInsttEmail("수정");
		instt.setInsttJob("수정");
		instt.setInsttFax("수정");
		instt.setInsttBank("수정");
		instt.setInsttSrttn("수정");
		instt.setInsttDtlSrttn("수정");
		instt.setInsttYear("수정");
		instt.setInsttBsnsNum("수정");
		instt.setInsttOfcName("수정");
		instt.setInsttAcadBack("수정");
		instt.setInsttAcadBakFile("수정");
		instt.setInsttCarrer("수정");
		instt.setInsttCarrerBack("수정");
		instt.setInsttAddr("수정");
		instt.setInsttDtlAddr("수정");
		mapper.updateInsttSuppapp(instt);
	}
	
	@Test
	public void updateTsTest() {
		TsVO ts = new TsVO();
		ts.setTsNum(6);
		ts.setTsName("수정6");
		ts.setTsHomeNum("수정");
		ts.setTsPhoneNum("수정");
		ts.setTsEmail("수정");
		ts.setTsBank("수정");
		ts.setTsExprt("수정");
		ts.setTsLngg("수정");
		ts.setTsDsgCrt("수정");
		ts.setTsActiveArea("수정");
		ts.setTsAcadBack("수정");
		ts.setTsAcadBackFile("수정");
		ts.setTsCarrer("수정");
		ts.setTsCarrerFile("수정");
		ts.setTsAddr("수정");
		ts.setTsDtlAddr("수정");
		mapper.updateTsSuppapp(ts);
	}
	
	@Test
	public void updateGhTest() {
		GhVO gh = new GhVO();
		gh.setGhNum(6);
		gh.setGhName("수정6");
		gh.setGhHomeNum("수정");
		gh.setGhPhoneNum("수정");
		gh.setGhEmail("수정");
		gh.setGhJob("수정");
		gh.setGhFax("수정");
		gh.setGhBank("수정");
		gh.setGhSrttn("수정");
		gh.setGhYear("수정");
		gh.setGhBsnsNum("수정");
		gh.setGhOfcNum("수정");
		gh.setGhOfcName("수정");
		gh.setGhAcadBack("수정");
		gh.setGhAcadBackFile("수정");
		gh.setGhCarrer("수정");
		gh.setGhCarrerFile("수정");
		gh.setGhAddr("수정");
		gh.setGhDtlAddr("수정");
		mapper.updateGhSuppapp(gh);
	}
	
	
	@Test
	public void deleteTest() {
		mapper.deleteSuppapp(5);
	}
	
	@Test
	public void deleteInsttTest() {
		mapper.deleteInsttSuppapp(5);
	}
	
	@Test
	public void deleteTsTest() {
		mapper.deleteTsSuppapp(5);
	}
	
	@Test
	public void deleteGhTest() {
		mapper.deleteGhSuppapp(5);
	}*/
}
