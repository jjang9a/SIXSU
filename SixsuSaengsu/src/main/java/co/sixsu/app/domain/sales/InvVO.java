package co.sixsu.app.domain.sales;

import java.util.Date;

import lombok.Data;

@Data
public class InvVO {
	private int ordId;
	private Date ordDate;
	private Date ordDueDate;
	private String ordStat;
	private int empId;
	private int busId;
	
	
}
