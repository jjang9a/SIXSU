package co.sixsu.app.basic.domain;

import lombok.Data;

@Data
public class ReceiveVO {

	String prcsPfmcId; // 공정실적코드
	int goodQt; // 공정실적 양품수량(공정실적) - 입고량
	String wkEnd; // 완료일(공정실적)  -> 입고일(sysdate)
	String empId; // 담당자
	
	String spId; // 반제품코드
	String spName; // 반제품명(제품)
	String spSize; // 반제품규격(제품)
	int spLot; // 반제품 LOT 규격(제품)
	String spRecId; // 입고번호
	String spLotId; // 반제품 LOT 번호
	int spQt; // 반제품 LOT 재고
	String spLotQtCk; // 반제품 적재량 도달 여부
	int spRecQt; // 반제품 입고수량
	String spRecDate; // 반제품 입고일
	String spRecType; // 반제품 입고 유형
	
	String cpId; // 완제품코드
	String cpName; // 완제품명(제품)
	int cpLot; // 완제품 LOT 규격(제품)
	String cpRecId; // 입고번호
	String cpLotId; // 완제품 LOT 번호
	int cpLotQt; // 완제품 LOT 재고
	String cpLotQtCk; // 완제품 적재량 도달 여부
	int cpRecQt; // 완제품 입고수량
	String cpRecDate; // 완제품 입고일
	String cpRecTp; // 완제품 입고 유형
	
}
