package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class DetaWorkOrdrVO {
	
	String wkDetaId;
	String wkHeadId;
	String cpId;
	String cpName;
	String startDate;
	String endDate;
	int detaQt;
	int dmatQt;
	int goodQt;
	String cmpltDate;
	String cmpltSt;
	String memo;
	String empId;
	String empName;
	String single;
	
	String planDetaId; //생산계획코드 (FK)
}
