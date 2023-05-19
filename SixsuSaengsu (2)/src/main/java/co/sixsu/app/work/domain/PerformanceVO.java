package co.sixsu.app.work.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PerformanceVO {
//공정실적
	
	String prcsPfmcId; //공정실적코드 (PK)
	String wkDetaId; //지시세부코드 (FK)
	String matId; //품목코드
	String matName; //품명
	String equCode; //설비코드
	Date wkStart; //착수일
	Date wkEnd; //완료일
	String wkLine; //라인
	String detaQt; //목표수량
	String goodQt; //양품수량
	String dmatQt; //불량수량
	String empId; //사원코드 (FK)
	
}
