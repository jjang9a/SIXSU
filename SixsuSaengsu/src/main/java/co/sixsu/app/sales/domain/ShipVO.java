package co.sixsu.app.sales.domain;

import lombok.Data;

@Data
public class ShipVO {
 public String cpShipId;
 public String ordDetId;
 public String cpLotId;
 public int cpShipQt;
 public String empId;
 public String cpShipReqDate;
 public String cpShipStat;
 public String inspNum;
 
 public int cpLotQt;
 public String cpLotQtCk;
 public int cpHold;
 long total;
}
