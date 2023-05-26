package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.sales.domain.OrdVO;

public interface ShipService {
	List<OrdVO> orderingList();//페이지 주문중인 목록 (품질요청 전 그리드 테이블)
}
