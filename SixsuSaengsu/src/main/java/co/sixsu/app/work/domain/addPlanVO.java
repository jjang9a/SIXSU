package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class addPlanVO {

	//프라이머리키
	String planHeadId;
	String planDetaId;
	
	String type; //분류
	String regDate; //작성일
	String startDate; //시작일
	
	String endDate; //종료일
	String empName; //사원이름 코드로 바꿔야 할듯?..
	
	//grid데이터
	String ordDetId; //세부주문코드
	String cpId; //제품코드
	//String cpName; //제품이름
	int ordQt; //주문수량
	int priority; //우선순위. 차 후에 작업
	String ordStatDet; //종결여부
	String memo;
	
}
