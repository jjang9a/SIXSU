package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.sales.domain.LotVO;
import co.sixsu.app.sales.domain.OrdVO;

public interface ShipService {
	List<OrdVO> orderingList();//페이지 주문중인 목록 (품질요청 전 그리드 테이블)
	List<LotVO> lotProducts(String keyword);//모달창 품목별 lot 재고현황
	int totalQt(String keyword); // 모달창에 자동으로 총수량이 뜨는 기능
}
