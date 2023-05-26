package co.sixsu.app.basic.domain;

public class ReceiveVO {

	String prcs_pfmc_id; // 공정실적코드
	String spId; // 반제품코드
	String spName; // 반제품명(제품)
	String spSize; // 반제품규격(제품)
	String spLot; // 반제품 LOT 규격(제품)
	int goodQt; // 공정실적 양품수량(공정실적) - 입고량
	String wkEnd; // 완료일(공정실적)  -> 입고일(sysdate)
	String empId; // 담당자
	
}
