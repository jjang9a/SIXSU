package co.sixsu.app.domain.work;

import java.util.Date;

import lombok.Data;

@Data
public class WorkOrdrVO {
//작업지시
	
	String wkHeadId; //작업지시코드 (PK)
	String empId; //사원코드 (FK)
	Date wkHeadStart; //시작일
	Date wkHeadEnd; //종료일
	String wkCmpltSt; //종결여부
	Date wkRegDate; //등록일
}
