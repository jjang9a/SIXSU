package co.sixsu.app.quality.domain;


import lombok.Data;

@Data
public class QuaVO {
	/*
	 * 품질 VO/ 검사 품목 코드 /사원 이름/ 검사 일자/ 검사 수량 /적합 수량/ 부적합 수량/ 검사 상태/ 검사 유형/검사 항목 코드/ 검사
	 * 항목 명/ 기준 값 /비고 /검사 품목 코드
	 */
	
	private String inspNum; // 검사번호
	private String inspItemId; // 검사 제품 코드
	private String empName;// 사원 이름
	private String inspDate; // 검사 일자
	private int inspQt; // 검사 수량
	private int suitQt; // 적합 수량
	private int nsuitQt; // 부적합 수량
	private String inspStat; // 검사 상태
	private String inspType; // 검사 유형
	private String inspId; // 검사 항목 코드
	private String inspName; // 검사 항목 명
	private String stdVal; // 기준 값
	private String inspNote; // 비고
	private String detInspNum; // 세부 검사 번호
	private String resVal; // 결과 값
	private String resStat; // 적합 여부
	private String inspStdId; // 검사 단위 코드(발주번호, 지시세부코드, 완제품출고코드)
	private String wkDetaId;// 지시 세부 코드
	// 완제품 출고 코드
	
	// 도착 자재 관련
	private String arrMatNum; // 도착 자재 번호
	private String matReqId; // 발주 번호
	private int arrQt; // 도착 수량
	private String arrDate; // 도착 날짜
	private String matId;// 자재 코드
	private String busName;// 거래처
	private String matName; // 자재 명
	
}
