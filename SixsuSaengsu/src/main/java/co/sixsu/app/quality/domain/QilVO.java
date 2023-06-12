package co.sixsu.app.quality.domain;

import lombok.Data;

@Data
public class QilVO {
	//품질 검사 항목 VO
	private String inspId; // 검사 항목 코드
	private String inspSep; // 검사 구분
	private String inspName; // 검사 항목 명
	private String inspExp; //검사 항목 설명
	private String stdVal; // 기준값
	private String inspItemId; //검사 제품 코드
	private String inspNote; // 비고
}
