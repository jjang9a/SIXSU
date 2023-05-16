package co.sixsu.app.domain.work;

import java.util.Date;

import lombok.Data;

@Data
public class ProdPlanVO { 
//생산계획
	
	String planHeadId; //생산계획코드 (PK)
	String empId; //사원코드 (FK)
	Date planStart; //시작일
	Date planEnd; //종료일
	String planDueDate; //납기일
	String planCompletionStatus; //종결여부
	Date planRegDate; //등록일
	String type; //분류
}
