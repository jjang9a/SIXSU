package co.sixsu.app.material.domain;

import lombok.Data;

@Data
public class MatShipVO {
	
	String prcsPfmcId;
	String matLotId;
	String matName;
	String matShipType;
	String matShipDate;
	int matShipQt;
	String matShipNote;
	String empName;
	
	String sDate;
	String eDate;
}
