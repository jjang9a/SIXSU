package co.sixsu.app.sales.domain;

import lombok.Data;

@Data
public class RecVO {
	String wkDetaId;
	String matId;
	String matName;
	int goodQt;
	String cmpltDate;
	String cmpltSt;
	
	
	String cpRecId;
	String cpRecTp;
	String prcsPfmcId;
	String empId;
	String cpRecDate;
	int cpRecQt;
	String cpLotId;
	
	String cpId;
	String cpName;
	String startDate;
	String endDate;
}
