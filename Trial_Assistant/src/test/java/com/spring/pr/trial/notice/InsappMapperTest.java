package com.spring.pr.trial.notice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.pr.command.InsVO;
import com.spring.pr.command.UserDetailVO;
import com.spring.pr.insapp.mapper.IInsappMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class InsappMapperTest {

	@Autowired IInsappMapper mapper;
	/*
	@Test
	public void getListTest() {
		System.out.println(mapper.getInsappList());
	}
	
	@Test
	public void getTotal() {
		System.out.println(mapper.getInsappTotal());
	}
	
	@Test 
	public void getContentTest() {
		System.out.println(mapper.getInsappContent("3번째 아이디"));
	}
	*/
	/*
	@Test
	public void updateTest1() {
		UserDetailVO ud = new UserDetailVO();
		ud.setJoinSocNum("3");
		ud.setJoinName("수정된 이름");
		ud.setJoinPhone("수정된 전화번호");
		ud.setJoinEmail("수정된 이메일");
		ud.setJoinAddrBasic("수정된 기본주소");
		ud.setJoinAddrDetail("수정된 상세주소");
		mapper.updateInsapp1(ud);
	}
	
	@Test
	public void updateTest2() {
		InsVO ins = new InsVO();
		ins.setJoinId("3번째 아이디");
		ins.setInsName("수정된 기관명");
		ins.setInsPhone("수정된 기관연락처");
		ins.setInsAddr("수정된 기관주소");
		mapper.updateInsapp2(ins);
	}
	
	@Test
	public void deleteTest1() {
		mapper.deleteInsapp1("6");
	}
	
	@Test
	public void deleteTest2() {
		mapper.deleteInsapp2(9);
	}
	
	@Test
	public void deleteTest3() {
		mapper.deleteInsapp3("7번째 아이디");
	}*/
}
