package com.spring.pr.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class pdfView extends AbstractPdfView{

	public Cell doc;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<String> list = (List<String>)model.get("list");
		
		//테이블을 생성
		//1열 list.size()+1 행으로 생성
		Table table = new Table(1,list.size()+1);
		//여백 설정
		table.setPadding(5);
		
		// 기본 폰트 설정 - 폰트에 따라 한글 출력 여부가 결정된다.
		BaseFont bfKorea = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0",BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
		Font font = new Font(bfKorea);
		
		Cell cell = new Cell(new Paragraph("데이터 처리에 많이 사용되는 언어",font));
		cell.setHeader(true);
		table.addCell(cell);
		table.endHeaders();
		
		//데이터를 테이블의 셀에 출력
		for(String language : list){
			Cell imsi = new Cell(new Paragraph(language,font));
			table.addCell(imsi);
		}
		//문서에 테이블 추가
		doc.add(table);
	}

}
