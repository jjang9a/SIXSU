package co.sixsu.app.material.domain;


import lombok.Data;

@Data
public class MatreqVO {
	String matReqId;
	String busId;
	String matId;
	int matReqQt;
	String matReqDate;
	String matReqStat;
	String matEndDate;
	String empId;
	
	String busName;
	String empName;
	String matName;
}
