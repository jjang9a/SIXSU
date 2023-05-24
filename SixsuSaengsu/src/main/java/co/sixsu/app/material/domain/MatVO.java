package co.sixsu.app.material.domain;

import lombok.Data;

@Data
public class MatVO {
	String matId;
	String matName;
	String matSize;
	
	
	//필요로 의해 VO필드 추가합니다.. -인규
	char matUnit;
	String matStat;
	String type;
}
