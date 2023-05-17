package co.sixsu.app.domain.quality;

import java.util.Date;

import lombok.Data;

@Data
public class QuaVO {
	/*
	 * 품질 VO/ 검사 품목 코드 /사원 이름/ 검사 일자/ 검사 수량 /적합 수량/ 부적합 수량/ 검사 상태/ 검사 유형/검사 항목 코드/ 검사
	 * 항목 명/ 기준 값 /비고 /검사 품목 코드
	 */
	
	private int inspNum; // 검사번호
	private String inspItemId; // 검사 품목 코드
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
	private int detInspNum; // 세부 검사 번호
	private String resVal; // 결과 값
	private String resStat; // 적합 여부
}
