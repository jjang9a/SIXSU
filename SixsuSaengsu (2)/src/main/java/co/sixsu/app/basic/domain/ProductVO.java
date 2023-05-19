package co.sixsu.app.basic.domain;

import lombok.Data;

@Data
public class ProductVO { // 완제품(complete_prod), 반제품(semi_prod) 테이블
	
	// 완제품
	private String cpId; // 제품코드
	private String cpName; // 제품명
	private String cpSize; // 규격
	private int cpLot; // LOT수량
	private String cpUnit; // 단위
	private char cpStat; // 활성여부(Y/N)
	private String cpNote; // 비고
	
	// 반제품
	private String spId; // 제품코드
	private String spName; // 제품명
	private String spSize; // 규격
	private int spLot; // LOT수량
	private String spUnit; // 단위
	private char spStat; // 활성여부(Y/N)
	private String spNote; // 비고
	


}
