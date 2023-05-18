package co.sixsu.app.domain.work;

import java.util.Date;

import lombok.Data;

@Data
public class DetaProdPlanVO {
//생산계획세부정보
	
	String type;
	String planDetaId; //생산계획코드 (FK)
	String matId; //제품코드
	String cpName; //제품이름
	int detaQt;
	int goodQt; //양품수량
	String status;
	String planDueDate;
	String startDate;
	String endDate;
	String empName;
	String memo; //비고


}
