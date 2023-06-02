package co.sixsu.app.material.domain;

import lombok.Data;

@Data
public class MatDmgVO {

	String dmatId;
	String dmatDate;
	String dmatStat;
	String dmatNote;
	String dmatResult;
	
	//새로운 불량품 페이지필요
	String inspNum;
	String inspDate;
	String matId;
	String matName;
	String matSize;
	int resVal;
	String empName;
}
