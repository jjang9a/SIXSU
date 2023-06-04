package co.sixsu.app.equipment.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class EquOperVO { // 비가동 관리

	String operCode; // 비가동코드
	String checkCode; // 점검코드
	String empId; // 사원코드
	String equCode; // 설비코드
	String equStat; // 설비상태
	String equName; // 설비명
	String operType; // 비가동구분(대기,중지,점검)
	String operStart; // 비가동 시작(일시분) 
	String operFnish; // 비가동 종료(일시분)
	String operNote; // 비가동 비고
}
