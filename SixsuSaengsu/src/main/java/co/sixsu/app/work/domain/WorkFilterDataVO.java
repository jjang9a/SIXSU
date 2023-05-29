package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class WorkFilterDataVO {

	String productName;
	String workNo;
	String writer;
	String makeFrom;
	String makeTo;
	String workFrom;
	String workTo;
	
	String[] statusCheckbox;
	String statusFilter;
	
}
