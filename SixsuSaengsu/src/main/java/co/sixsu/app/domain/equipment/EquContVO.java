package co.sixsu.app.domain.equipment;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EquContVO { // 설비관리

	String equCode; // 설비코드
	String empId; // 사원코드
	String procId; // 공정코드
	String equName; // 설비명
	String equCheck; // 점검주기
	String equLine; // 설비라인
	String equModel; // 설비모델
	String equImg; // 설비 이미지
	String equStat; // 설비상태
	
	
}
