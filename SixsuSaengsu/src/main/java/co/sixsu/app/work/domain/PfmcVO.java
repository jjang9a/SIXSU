package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class PfmcVO { // 공정실적

	private String prcsPfmcId; // 공정실적코드
	private String wkDetaId; // 세부지시코드
	private String pdId; // 제품코드
	private String pdName; // 제품명
	private String equCode; // 설비코드
	private String wkLine; // 라인
	private String empId; // 담당자 사원코드
	private String wkStart; // 착수일
	private String wkEnd; // 완료일
	private int detaQt; // 지시수량
	private int dmatQt; // 불량수량
	private int goodQt; // 양품수량
	private String wkBomId; // 지시BOM코드
	
	private String pdUnit; // 제품 단위
}
