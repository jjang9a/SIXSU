package co.sixsu.app.domain.work;

import lombok.Data;

@Data
public class PlanDataVO {

	private String productName;
	private String planNo;
	private String writer;
	private String[] planCheckbox; // 나중에하자... 문자열비교아닌 논리적 조건이니..
	private String planFilter;
	private String[] statusCheckbox;
	private String statusFilter;
}
