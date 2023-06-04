package co.sixsu.app.sales.domain;

import lombok.Data;

@Data
public class ShipCompVO {
	public String ordDetId;
	public String ordDate;
	public String cpId;
	public String cpName;
	public int ordQt;
	public String cpShipReqDate;
	public String busId;
	public String busName;
	
}
