package co.sixsu.app.basic.domain;

import lombok.Data;

@Data
public class BomVO { // BOM 테이블
	
	private String bomId; // BOM코드
	private String pdId; // 제품코드 **** 필드명 주의 *****
	private String bomMat; // 소요 자재(반제품)코드 **** 필드명 주의 ****
	private int bomNum; // 소요량
	private String bomUnit; // 단위
	private String procId; // 소요 공정코드
	private String updateDate; // 수정일자
	
	private String cpName; // 제품명
	private String cpSize; // 제품 규격
	private String cpType; // 제품 유형 (완제품/반제품)
	private String matName; // 투입자재명
	private String matSize; // 투입자재 규격
	private String matType; // 투입자재 유형 (자재/반제품)
	private String procName; // 공정명
	
}
