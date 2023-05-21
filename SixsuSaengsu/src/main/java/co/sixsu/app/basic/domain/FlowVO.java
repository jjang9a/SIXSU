package co.sixsu.app.basic.domain;

import lombok.Data;

@Data
public class FlowVO { // 공정흐름도(folw) 테이블
	
	private String flowId; // 제품흐름코드
	private String pdId; // 제품코드
	private int flow_num; // 순서
	private String procId; // 공정코드
	
	private String cpName; // 제품명
	private String procType; // 공정구분
	private String procName; // 공정명
}
