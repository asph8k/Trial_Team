package com.spring.pr.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageCreator {
	   private PageVO paging;
	   private int articleTotalCount;//총 게시물의 수
	   private int endPage;	//끝페이지번호
	   private int beginPage;//시작페이지번호
	   private boolean prev;//이전 버튼 활성화 여부
	   private boolean next;//다음버튼 활성화 여부
	   
	   private final int buttonNum = 5;	//한 화면에 보여질 페이지 버튼 수
	   
	 //URI 파라미터를 쉽게 만들어 주는 유틸 메서드
		public String makeURI(int page) {
			System.out.println("pc객체의 page: "+page);
			UriComponents ucp = UriComponentsBuilder.newInstance().queryParam("page", page)
																  .queryParam("cpp", paging.getCpp())
																  .queryParam("keyword", paging.getKeyword())
																  .queryParam("condition", paging.getCondition())
																  .build();
			return ucp.toUriString();
		}
	   
	   private void calcDataOfPage() {
	      
		  //보정 전 끝 페이지 구하는 공식
	      endPage = (int) (Math.ceil(paging.getPageNum() / (double) buttonNum) * buttonNum);
	      
	      //시작 페이지 번호 구하기
	      beginPage = (endPage - buttonNum) + 1;
	      
	      //현재 시작 페이지가 1이라면 이전 버튼 비활성화
	      prev = (beginPage == 1) ? false : true;
	      
	      //마지막 페이지인지 여부 확인 후 다음 버튼 비활성화 판단
	      next = articleTotalCount <= (endPage * paging.getCpp()) ? false : true;
	      
	      //다음 버튼이 비활성화라면 끝 페이지 보정하기
	      if(!next) {
	         endPage = (int) Math.ceil(articleTotalCount / (double) paging.getCpp()); 
	      }
	      
	   }
	   
	   //컨트롤러가 총 게시물의 개수를 PageCreator에게 전달한 직후에  바로 페이징 버튼 알고리즘이 돌아갈 수 있도록 setter를 커스텀.
	   public void setArticleTotalCount(int articleTotalCount) {
	      this.articleTotalCount = articleTotalCount;
	      System.out.println(articleTotalCount);
	      calcDataOfPage();
	   }

}
