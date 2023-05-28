package co.sixsu.app.quality.domain;

import lombok.Data;

@Data
public class PrdInspVO {
	private String inspNum; // 검사번호
	private String wkDetaId; // 세부 지시 번호
	private String cpId; // 제품 코드
	private String cpName; // 제품 이름
	private String endDate; // 종결 일자
	private String procId; //공정 코드
	private String procName; //공정 이름
	private int detaQt; // 지시 수량
	private String cmpltSt; // 종결 여부
	private String empId; // 사원 번호 
	private String empName; // 사원 이름
	
}
