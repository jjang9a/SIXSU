package co.sixsu.app.sales.domain;

import java.util.Date;

import lombok.Data;

@Data
public class InvVO {
	private String ordId;
	private Date ordDate;
	private String ordStat;
	private int empId;
	private int busId;
	
	
}
