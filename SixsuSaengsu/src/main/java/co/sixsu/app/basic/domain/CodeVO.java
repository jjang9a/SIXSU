package co.sixsu.app.basic.domain;

import lombok.Data;

@Data
public class CodeVO { // GROUP_CODE & COMMON_CODE 테이블

	private String gId; // 그룹코드
	private String gName; // 그룹명
	
	private String comId; // 공통코드
	private String comName; // 공통코드 이름
	private String comNote; // 비고, 설명
	private char comStat; // 사용여부(Y/N)
	
	private String searchType; // 검색시 구분 용도로 사용할 필드
}
