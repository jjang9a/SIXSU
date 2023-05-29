package co.sixsu.app.quality.domain;

import lombok.Data;

@Data
public class QudVO {
	
	private String detInspNum; // 세부 검사 번호
	private String inspNum; // 검사 번호
	private String inspId; // 검사 항목 코드
	private String resVal; // 결과 값
	private String resStat; // 적합 여부
	private int nsuitQt;// 부적합 수량

}
