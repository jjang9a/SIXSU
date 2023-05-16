package co.sixsu.app.domain.work;

import java.util.Date;

import lombok.Data;

@Data
public class DetaProdPlanVO {
//생산계획세부정보
	
	String planDetaId; //계획세부코드 (PK)
	String planHeadId; //생산계획코드 (FK)
	int ordDetId; //주문상세코드 (FK)
	String matId; //제품코
	int good_qt; //양품수량
	String cmplt_st; //종결여부
	Date detaEnd; //종결일

}
