package co.sixsu.app.equipment.domain;

import lombok.Data;

@Data
public class EquConVO {

	// 설비관리 EquConVO

		String equCode; // 설비코드
		String procId; // 공정코드
		String equStat; // 설비상태
		String equName; // 설비명
		String equLine; // 설비라인
		String equModel; // 설비모델
		String equSuit; // 판정
		String checkDate; // 점검일자 Date
		String equCheck; // 점검주기 개월
		String checkNext; // 차기점검일 Date
		String checkType; // 점검구분 
		String checkInfo; // 점검사유
		String operStart;  // 비가동시작 Date
		String operFnish; // 비가동 종료
		String operType; // 비가동구분
		String operNote; // 비가동사유
		String empId; // 사원코드
		Integer ctemp; // 기준온도
		String addDate; // 등록일자
	
		
		
}
