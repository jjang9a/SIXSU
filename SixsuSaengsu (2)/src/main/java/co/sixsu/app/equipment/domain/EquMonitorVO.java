package co.sixsu.app.equipment.domain;

import lombok.Data;

@Data
public class EquMonitorVO { // 설비온도모니터링
	
	String statCode; // 모니터링코드
	String equCode; // 설비코드
	int cTemp; // 기준온도
	int oTemp; // 현재온도
	String operTime; // 시간
	
}
