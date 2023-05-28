package co.sixsu.app.sales.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.sales.domain.LotVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.mapper.ShipMapper;
import co.sixsu.app.sales.service.ShipService;

@Service("shipService")
public class ShipServiceImpl implements ShipService {
@Autowired ShipMapper mapper;

@Override//페이지 주문중인 목록 (품질요청 전 그리드 테이블)
public List<OrdVO> orderingList() {
	
	return mapper.orderingList();
}

@Override //모달창 품목별 lot 재고현황
public List<LotVO> lotProducts(String keyword) {
	// TODO Auto-generated method stub
	return mapper.lotProducts(keyword);
}


@Override//모달창에 자동으로 총수량이 뜨는 기능
public int totalQt(String keyword) {
	// TODO Auto-generated method stub
	return mapper.totalQt(keyword);
}

}
