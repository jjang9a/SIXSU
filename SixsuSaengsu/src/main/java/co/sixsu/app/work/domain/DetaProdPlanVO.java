package co.sixsu.app.work.domain;


import java.util.Date;

import lombok.Data;

@Data
public class DetaProdPlanVO {
//생산계획세부정보
	
	String type;
	String planDetaId; //생산계획코드 (FK)
	String matId; //제품코드
	String cpId;
	String cpName; //제품이름
	int detaQt; //지시수량
	int goodQt; //양품수량
	String status; //상태
	String planDueDate; //납기일
	String startDate; //작업시작일
	String endDate; //작업종료일
	String empName;
	String memo; //비고
	String regDate; //작성일. 자바에서 사용할 것
	
	
	String ordDetId;
	int ordQt;
	String ordStatDet;

	String ordId;
	int ordDetPrice;
	int ordSalePrice;
	String ordEndDate;
	String cpSize;

}
