package com.spring.pr.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppVO {

	private String JoinId;
	private int AppNumSeq;
	
	/*GH테이블과 TOTALAPPLLIER 테이블에서 조인해서 조회된 컬럼들
gh.GH_NUM_SEQ, gh.gh_name, ta.joinid, gh.gh_soc_num, gh.gh_home_num, gh.gh_phone_num, gh.gh_email,
        		gh.gh_job, gh.gh_fax, gh.gh_bank, gh.gh_acc_hol, gh.gh_bank_num, gh.gh_srttn, gh.gh_year,
        		gh.gh_bsns_num, gh.gh_ofc_num, gh.gh_ofc_name, gh.gh_acad_back, gh.gh_acad_back_file,
        		gh.gh_carrer, gh.gh_carrer_file, gh.gh_addr, gh.gh_dtl_addr, gh.gh_dtl_srttn, gh.APP_NUM_SEQ, gh.gh_post_num, gh.gh_memo
*/
	private int GhNumSeq;
	private String GhName;
	private String GhSocNum;
	private String GhHomeNum;
	private String GhPhoneNum;
	private String GhEmail;
	private String GhJob;
	private String GhFax;
	private String GhBank;
	private String GhAccHol;
	private String GhBankNum;
	private String GhSrttn;
	private String GhYear;
	private String GhBsnsNum;
	private String GhOfcNum;
	private String GhOfcName;
	private String GhAcadBack;
	private String GhAcadBackFile;
	private String GhCarrer;
	private String GhCarrerFile;
	private String GhAddr;
	private String GhDtlAddr;
	private String GhDtlSrttn;
	private String GhPostNum;
	private String GhMemo;
	private String GhSupappMemo;
	
	/*TS테이블과 TOTALAPPLLIER 테이블에서 조인해서 조회된 컬럼들
ts.TS_NUM_SEQ, ts.ts_name, ta.joinid, ts.ts_soc_num, ts.ts_home_num, ts.ts_phone_num, ts.ts_email,
	        ts.ts_bank, ts.ts_acc_hol, ts.ts_bank_num, ts.ts_exprt, ts.ts_lngg, ts.ts_dsg_crt, ts.ts_active_area,
	        ts.ts_acad_back, ts.ts_acad_back_file, ts.ts_carrer, ts.ts_carrer_file,
	        ts.ts_addr, ts.ts_dtl_addr, ts.ts_post_num, ts.ts_srttn, ts.ts_year, ts.ts_dtl_srttn, ts.APP_NUM_SEQ, ts.ts_memo
*/
	private int TsNumSeq;
	private String TsName;
	private String TsSocNum;
	private String TsHomeNum;
	private String TsPhoneNum;
	private String TsEmail;
	private String TsBank;
	private String TsAccHol;
	private String TsBankNum;
	private String TsExprt;
	private String TsLngg;
	private String TsDsgCrt;
	private String TsActiveArea;
	private String TsAcadBack;
	private String TsAcadBackFile;
	private String TsCarrer;
	private String TsCarrerFile;
	private String TsAddr;
	private String TsDtlAddr;
	private String TsPostNum;
	private String TsSrttn;
	private String TsYear;
	private String TsDtlSrttn;
	private String TsMemo;
	private String TsSupappMemo;
	
	/*INSTT테이블과 TOTALAPPLLIER 테이블에서 조인해서 조회된 컬럼들
 it.INSTT_NUM_SEQ, it.instt_name, ta.joinid, it.instt_soc_num, it.instt_home_num, it.instt_phone_num, it.instt_email,
	        it.instt_job, it.instt_fax, it.instt_bank, it.instt_acc_hol, it.instt_bank_num,
	        it.instt_srttn, it.instt_dtl_srttn, it.instt_year,
	        it.instt_bsns_num, it.instt_ofc_name,
	        it.instt_acad_back, it.instt_acad_back_file, it.instt_carrer, it.instt_carrer_file,
	        it.instt_addr, it.instt_dtl_addr, it.instt_post_num, it.APP_NUM_SEQ, it.instt_memo*/
	
	private int InsttNumSeq;
	private String InsttName;
	private String InsttSocNum;
	private String InsttHomeNum;
	private String InsttPhoneNum;
	private String InsttEmail;
	private String InsttJob;
	private String InsttFax;
	private String InsttBank;
	private String InsttAccHol;
	private String InsttBankNum;
	private String InsttSrttn;
	private String InsttDtlSrttn;
	private String InsttYear;
	private String InsttBsnsNum;
	private String InsttOfcName;
	private String InsttAcadBack;
	private String InsttAcadBackFile;
	private String InsttCarrer;
	private String InsttCarrerFile;
	private String InsttAddr;
	private String InsttDtlAddr;
	private String InsttPostNum;
	private String InsttMemo;
	private String InsttSupappMemo;

}
