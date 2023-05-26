package co.sixsu.app.material.domain;

import lombok.Data;

@Data
public class MatShipVO {
	String matShipId;
	String prcsPfmcId;
	String matLotId;
	String matShipType;
	String matShipDate;
	int matShipQt;
	String matShipNote;
	String empId;
}
