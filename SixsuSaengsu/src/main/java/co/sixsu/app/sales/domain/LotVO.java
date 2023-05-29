package co.sixsu.app.sales.domain;

import lombok.Data;

@Data
public class LotVO {
	private String cpLotId;
	private String cpId;
	private int cpLotQt;
	private String cpLotQtCk;
	private String cpName;
	private int cpHold;
}
