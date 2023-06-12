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
	private String empName; // 사원 이름
	private String retStat; // 반품 진행 상태
	private String retDate; //반품 일자
	private String cpId; // 제품코드
	private String cpName; // 제품명
	private String endDate; // 제조일자
	private String expDate; // 유통기한
	
	private int nsuitQt; // 부적합 수량
	private int suitQt; // 적합 수량
	private String resVal; //결과값
	private String resStat; // 적합여부
	private String inspId; // 검사 항목코드
	private String inspType; // 검사유형
	private String detInspNum; // 세부 검사 번호
	
}
