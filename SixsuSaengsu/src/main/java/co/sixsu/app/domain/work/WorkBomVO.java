package co.sixsu.app.domain.work;

import lombok.Data;

@Data
public class WorkBomVO {
//지시BOM
	
	String wkBomId; //지시BOM코드 (PK)
	String wkDetaId; //지시세부코드 (FK)
	String procId; //공정코드 (FK)
	String matWorkLotId; //자재LOT번호
	int bomNum; //사용수량
	String matUnit; //단위
	int flowNum; //순서
	
}
