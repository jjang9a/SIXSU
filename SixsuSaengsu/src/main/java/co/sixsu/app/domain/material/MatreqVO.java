package co.sixsu.app.domain.material;


import java.util.Date;

import lombok.Data;

@Data
public class MatreqVO {
	int matReqId;
	String busId;
	String matId;
	int matReqQt;
	Date matReqDate;
	String matReqStat;
	Date matEndDate;
	int matDlyDate;
	String empId;
	
	String busName;
	String empName;
}
