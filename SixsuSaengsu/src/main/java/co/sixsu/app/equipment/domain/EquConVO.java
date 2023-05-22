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
		// checkDate; // 점검일자
		String equCheck; // 점검주기
		// checkNext; // 차기점검일
		// checkType; // 점검구분
		//checkInfo //점검사유
		//operStart  // 비가동시간
		// opreNote // 비가동사유
		String equImg; // 설비 이미지
		String empId; // 사원코드
		
		
		public EquConVO() {
			
		}
		
		public EquConVO (String equCode, String procId, String equName, String equModel, String equStat, String equLine, String equCheck, String equImg, String empId) {
		this.equCode = equCode;
		this.procId = procId;
		this.equName = equName;
		this.equModel = equModel;
		this.equStat = equStat;
		this.equLine = equLine;
		this.equCheck = equCheck;
		this.equImg = equImg;
		this.empId = empId;
		
		
		}

		
		
}
