package co.sixsu.app.sales.domain;

import java.util.List;

import lombok.Data;

@Data
public class InvVO {
	private String ordId;
	private String ordDate;
	private String ordFDate;
	private String ordStat;
	private String empId;
	private String busId;
	
	
	private String busName;
	private String busNum;
	private String busAddr;
	private String busTell;
	
	private String empName;
	
	private String ordStatName;
	
	List<OrdVO> list;
}
