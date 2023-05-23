package co.sixsu.app.equipment.domain;

import lombok.Data;

@Data
public class EquInspVO {

	String checkCode; // 점검코드
	String equCode; // 설비코드
	String empId; // 사원코드
	String equName; // 설비명
	String operCode; // 비가동코드
	String checkDate; // 점검일자 Date
	String checkNext; // 차기점검일 Date
	String checkType; // 점검구분
	String checkInfo; // 점검내역
	String checkCom; // 조치내역
	String equCheck; // 점검주기
	String equStat; // 설비상태
	String equSuit; // 적합여부
	String checkNote; // 비고란
}
