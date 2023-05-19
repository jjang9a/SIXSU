package co.sixsu.app.material.domain;


import lombok.Data;

@Data
public class MatreqVO {
	int matReqId;
	String busId;
	String matId;
	int matReqQt;
	String matReqDate;
	String matReqStat;
	String matEndDate;
	String matDlyDate;
	String empId;
	
	String busName;
	String empName;
	String matName;
}
