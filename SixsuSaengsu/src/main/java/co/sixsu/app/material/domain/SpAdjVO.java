package co.sixsu.app.material.domain;

import lombok.Data;

@Data
public class SpAdjVO {
	
	String spLotId;
	String spId;
	String spName;
	String spSize;
	int spQt;
	int spAdjQt;
	
	String empId;
}
