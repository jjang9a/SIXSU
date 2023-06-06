package co.sixsu.app.equipment.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class EquInspVO {

	String checkCode; // 점검코드
	String equCode; // 설비코드
	String operCode; // 비가동코드
	String empId; // 사원코드
	String empName;
	String equName; // 설비명
	String equCheck; // 점검주기
	String checkDate; // 점검일자 Date
	String checkNext; // 차기점검일 Date
	String checkType; // 점검구분(수시,정기)
	String checkInfo; // 점검사유(손상(결함),설치상태,기능점검)
	String checkCom; // 조치내역(기능고장 수리완료/부품손상 교체/설치상태 검
	String equSuit; // 판정(점검) 적합/부적합 
	String equStat; // 설비상태(가동/비가동)
	String checkNote; // 점검비고
	String operStart; // 비가동 시작(일시분)
}
