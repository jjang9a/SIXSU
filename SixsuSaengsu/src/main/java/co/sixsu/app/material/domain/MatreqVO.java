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
	String matSize;
	
	// 발주/납기일 조건
	String matInSDate;
	String matInEDate;
	String matEndSDate;
	String matEndEDate;
}
