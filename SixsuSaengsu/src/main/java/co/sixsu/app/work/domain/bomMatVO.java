package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class bomMatVO {
	
	String bomMatId;
	String wkBomId;
	String matId;
	String matName;
	int cpQt;
	String matSize;
	String type;
	
	String comName;
	String procId;
	String procName;
}
