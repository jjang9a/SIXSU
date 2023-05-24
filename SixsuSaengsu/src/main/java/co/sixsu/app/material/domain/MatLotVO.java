package co.sixsu.app.material.domain;

import lombok.Data;

@Data
public class MatLotVO {
	String matLotId;
	String matId;
	String matName;
	String matSize;
	int matQt;
	String matHoldStat;
	String matRecDate;
}
