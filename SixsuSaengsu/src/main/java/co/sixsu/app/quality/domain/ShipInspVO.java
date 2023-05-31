package co.sixsu.app.quality.domain;

import lombok.Data;

@Data
public class ShipInspVO {
	//완제품 출고 검사 VO
	 public String cpShipId; // 완제품 출고 코드 (inspStdId)
	 public String ordDetId; // 주문 상세 코드
	 public String cpLotId; // 완제품 LOT 코드
	 public String cpId; // 완제품코드
	 public String cpName; // 완제품 이름
	 public String expDate;// 유통기한
	 public String endDate; // 제조일자(작업지시세부정보종료날짜)
	 public String note; // 비고
	 
	 public int cpShipQt; // 출고수량
	 public String empId; // 사원코드
	 
	 public String cpShipReqDate; // 출고요청일자
	 public String inspDate; // 완료일자
	 public String cpShipStat; //출고 진행상태(검수상태)
	 public String inspNum; // 검사번호
	 public String detInspNum; // 세부 검사번호
	 
	 public int nsuitQt; // 부적합 수량
	 public int suitQt; // 적합 수량
	 public String resVal; //결과값
	 public String resStat; // 적합여부
	 public String inspId; // 검사 항목코드
	 

}
