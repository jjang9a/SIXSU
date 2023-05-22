package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class detOrdVO {

	String ordDetId; //세부주문코드
	String cpId;
	String cpName;
	int ordQt;
	String ordEndDate;
	String ordStatDet;
}
