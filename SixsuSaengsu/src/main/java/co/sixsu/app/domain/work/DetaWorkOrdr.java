package co.sixsu.app.domain.work;

import java.util.Date;

import lombok.Data;

@Data
public class DetaWorkOrdr {
//작업지시세부정보
	
	String wkDetaId; //지시세부코드 (PK)
	String wkHeadId; //작업지시코드 (FK)
	String planDetaId; //계획세부코드 (FK)
	String matId; //품목코드
	String matName; //품명
	int detaQt; //지시수량
	int goodQt; //양품수량
	int dmatQt; //불량수량
	String cmpltSt; //종결여부
	Date cmpltDate; //종결일자
}
