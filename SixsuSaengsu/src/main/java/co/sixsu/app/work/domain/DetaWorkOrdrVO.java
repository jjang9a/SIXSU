package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class DetaWorkOrdrVO {
	
	String wkDetaId;
	String wkHeadId;
	String matId;
	String matName;
	String startDate;
	String endDate;
	int detaQt;
	int dmatQt;
	int goodQt;
	String cmpltDate;
	String cmpltSt;
	String memo;
	String empId;
}
