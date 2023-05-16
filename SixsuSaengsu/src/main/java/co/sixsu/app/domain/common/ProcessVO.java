package co.sixsu.app.domain.common;

import lombok.Data;

@Data
public class ProcessVO { // 공정(Process) 테이블

	private String procId; // 공정코드
	private String procType; // 공정분류 - 공통코드
	private String procName; // 공정명
	private char procStat; // 활성여부(Y/N)
	private String procNote; // 비고
	
}
