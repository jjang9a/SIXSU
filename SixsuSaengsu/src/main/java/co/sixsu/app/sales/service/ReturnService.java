package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.sales.domain.ShipCompVO;

public interface ReturnService {
		List<ShipCompVO> orderComplete(String keyword);

}
