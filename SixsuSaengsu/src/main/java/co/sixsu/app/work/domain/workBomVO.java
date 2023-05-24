package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class workBomVO {

	String wkBomId;
	String wkDetaId;
	String procId;
	String matWorkLotId;
	int bomNum;
	String matUnit;
	int flowNum;
}
