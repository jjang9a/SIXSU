package co.sixsu.app.work.domain;

import lombok.Data;

@Data
public class PlanDataVO {

	String productName;
	String planNo;
	String writer;
	String[] planCheckbox; // 나중에하자... 문자열비교아닌 논리적 조건이니..
	String planFilter;
	String[] statusCheckbox;
	String statusFilter;
	String makeFrom;
	String makeTo;
	String planFrom;
	String planTo;
	
}
