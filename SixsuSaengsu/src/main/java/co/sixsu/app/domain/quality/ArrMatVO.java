package co.sixsu.app.domain.quality;

import java.util.Date;

import lombok.Data;

@Data
public class ArrMatVO {
	private String arrMatNum; // 도착 자재 번호
	private int matReqId; // 발주 번호
	private int arrQt; // 도착 수량
	private Date arrDate; // 도착 날짜

	//출력 데이터
	private String matId;// 자재 코드
	private String busName;// 거래처
	private String matName; // 자재 명
	
}
