package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class SorderVO {

	int ordId;
	int busId;
	String bus_name;
	String ordDueDate;
	String ordDate;
	String ordStat;
}
