package co.sixsu.app.quality.domain;

import lombok.Data;

@Data
public class ReturnInspVO {
	//반품 검사 VO
	private String retId; // 반품코드
	private String cpShipId; // 완제품 출고 코드
	private int retQt; // 반품 수량
	private String retNote; // 반품 사유
	private String inspNum; // 검사번호
	private String empId; // 사원코드
	private String retStat; // 반품 진행 상태
	private String retDate; //반품 일자
	
	 public int nsuitQt; // 부적합 수량
	 public int suitQt; // 적합 수량
	 public String resVal; //결과값
	 public String resStat; // 적합여부
	 public String inspId; // 검사 항목코드
	 public String inspType; // 검사유형
}
