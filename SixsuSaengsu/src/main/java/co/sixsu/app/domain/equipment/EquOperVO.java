package co.sixsu.app.domain.equipment;

import java.sql.Date;

import lombok.Data;

@Data
public class EquOperVO { // 비가동 관리

	String operCode; // 비가동코드
	String equCode; // 설비코드
	String checkCode; // 점검코드
	String empId; // 사원코드
	String equStat; // 설비상태
	String operNote; // 비가동사유
	Date operStart; // 비가동 시작(일시분) 
	Date operFnish; // 비가동 종료(일시분)
	String equName; // 설비명 점검일자 점검주기 판정
	
}
