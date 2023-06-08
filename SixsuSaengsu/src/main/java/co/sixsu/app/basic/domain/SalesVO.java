package co.sixsu.app.basic.domain;

import lombok.Data;

@Data
public class SalesVO {
	
	private String cpId; // 상품코드
	private String cpName; // 상품명
	private int sales; // 판매액
	private int count; // 판매수량
	
	private String date1; // 검색용 시작날짜
	private String date2; // 검색용 종료날짜
}
