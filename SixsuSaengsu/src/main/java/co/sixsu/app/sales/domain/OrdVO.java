package co.sixsu.app.sales.domain;

import java.util.Date;

import lombok.Data;
@Data
public class OrdVO {
	private String ordDetId;
	private int ordQt;
	private String ordStatDet;
	private String cpId;
	private String cpName;
	private String ordId;
	private int ordDetPrice;
	private int ordSalePrice;
	private String ordEndDate;
	private String cpSize;
	private String ordDate;
	private int cpLot;
	private String ordStatDetName;
	private String busName;
	
	private String empId;
	private int totalProd;
	private String startDate;
	private String endDate;
	
}
