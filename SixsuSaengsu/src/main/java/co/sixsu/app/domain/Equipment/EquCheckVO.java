package co.sixsu.app.domain.Equipment;

import java.util.Date;

import lombok.Data;

@Data
public class EquCheckVO {

	String checkCode;
	String equCode;
	String empId;
	String equName;
	String operCode;
	Date checkDate;
	Date checkNext;
	String checkType;
	String checkInfo;
	String checkCom;
	String equCheck;
	String equStat;
	String equSuit;
	String checkNote;
	
	
}
