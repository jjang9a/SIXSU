package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.sales.domain.RecVO;
import co.sixsu.app.sales.domain.RetVO;
import co.sixsu.app.sales.domain.ShipCompVO;

public interface ReturnService {
		List<ShipCompVO> orderComplete(String keyword);

		boolean returnRequest(RetVO vo);
		
		List<RetVO> searchReturn(RetVO vo);// 반품요청 준비상태
}
