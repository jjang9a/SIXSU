package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.sales.domain.LotVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.domain.RetVO;
import co.sixsu.app.sales.domain.ShipVO;

public interface ShipService {
	List<OrdVO> orderingList(OrdVO vo);//페이지 주문중인 목록 (품질요청 전 그리드 테이블)
	List<LotVO> lotProducts(String keyword);//모달창 품목별 lot 재고현황
	int totalQt(String keyword); // 모달창에 자동으로 총수량이 뜨는 기능
	
	
	List<ShipVO> shipPro(OrdVO ord);
	List<ShipVO> readyShipList(String keyword);
	
	
	void completeShip(ShipVO vo);
	List<ShipVO> searchShip(ShipVO vo);
}
