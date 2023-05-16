package co.sixsu.app.domain.common;

import lombok.Data;

@Data
public class MaterialVO {  // 자재(Material) 테이블

	private String matId; // 자재코드
	private String matName; // 자재이름
	private String matSize; // 규격
	private String matUnit; // 단위
	private int matSafe; // 안전재고량
	private char matStat; // 활성여부(Y/N)
	private String matNote; // 비고
}
