package co.sixsu.app.domain.common;

import lombok.Data;

@Data
public class BusVO { // 거래처 테이블(business)
	
	private String busId; // 거래처코드
	private String busType; // 거래처 유형 (매출, 매입) - 공통코드
	private String busName; // 거래처 명
	private int busNum; // 사업자번호
	private String busTell; // 전화번호
	private String busAddr; // 주소
	private char busStat; // 사용여부 (Y/N)
	private String busNote; // 비고
}
