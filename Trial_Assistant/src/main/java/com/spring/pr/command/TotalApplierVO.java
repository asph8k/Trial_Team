package com.spring.pr.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE TotalApplier (
	APP_NUM_SEQ	NUMBER(10)	NOT NULL,
	JOIN_ID	VARCHAR2(20)	NOT NULL,
	APP_WHTR_INGB	VARCHAR2(2)	NOT NULL,
	APP_DATE	DATE DEFAULT SYSDATE NOT NULL,
	APP_CLASSIFICATION	VARCHAR2(50)	NOT NULL,
	APP_NAME VARCHAR2(30) DEFAULT ' ' NOT NULL
	);
	
	CREATE SEQUENCE APP_NUM_SEQ_NAME
	    START WITH 1
	    INCREMENT BY 1 
	    MAXVALUE 1000
	    NOCYCLE 
	    NOCACHE;
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TotalApplierVO {
	
	private int AppNum;
	private String JoinId;
	private String AppWhtrIngb;
	private Timestamp AppDate;
	private String AppClassification;
	private String AppName;
	
	//추가된 변수
	private String appInsName;
	private String appInsPhone;
	private String appJoinName;
	private String appJoinPw;
	private String appJoinPhone;
	private String appJoinEmail;
	private String appJoinGen;
	private String appJoinSocNum;
	private String appJoinAddrBasic;
	private String appJoinAddrDetail;

}
