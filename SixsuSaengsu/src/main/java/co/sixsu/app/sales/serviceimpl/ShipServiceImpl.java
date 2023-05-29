package co.sixsu.app.sales.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.sixsu.app.sales.domain.LotVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.domain.ShipVO;
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

@Override
@Transactional
public List<ShipVO> shipPro(OrdVO ord) {
	String id = ord.getCpId();
	int qt = ord.getOrdQt();
	int lot = ord.getCpLot();
	
	List<LotVO> list = mapper.lotProducts(id);
	List<ShipVO> ship = new ArrayList<>(); // 출고목록을 담을 객체
	
	int i = 0;
	
	while (qt >= lot) {
		ShipVO vo = new ShipVO();
		vo.setOrdDetId(ord.getOrdDetId());
		vo.setCpLotId(list.get(i).getCpLotId()); // LOT번호
		int lotQt = list.get(i).getCpLotQt();
		vo.setCpShipQt(list.get(i).getCpLotQt()); //지금 LOT안의 수량을 출고수량으로 설정
		list.get(i).setCpHold(list.get(i).getCpLotQt()); // 현재 수량을 홀드수량에 셋팅
		list.get(i).setCpLotQt(0);// 현재수량을 0으로 만듦
		vo.setEmpId("test");
		vo.setCpShipStat("검사요청");
		System.out.println(vo);
		mapper.insertProShip(vo);
		mapper.updateCpLot(list.get(i));
		ship.add(vo);
		qt -= lotQt;
		i++;
	}
	
	if (qt != 0 ) {
		
	
	
		ShipVO vo = new ShipVO();
		vo.setOrdDetId(ord.getOrdDetId()); //여러건이 발생하고 있음
		
		
		vo.setCpLotId(list.get(i).getCpLotId()); // LOT번호
		vo.setCpShipQt(qt); //지금 LOT안의 수량을 출고수량으로 설정
		list.get(i).setCpHold(qt); // 현재 수량을 홀드수량에 셋팅
		list.get(i).setCpLotQt(list.get(i).getCpLotQt() - qt);// 현재수량을 0으로 만듦
		vo.setEmpId("test");
		vo.setCpShipStat("검사요청");
		
		mapper.insertProShip(vo);
		mapper.updateCpLot(list.get(i));
		ship.add(vo);}	
		return ship;
}

@Override
public List<ShipVO> readyShipList() {
	// TODO Auto-generated method stub
	return mapper.readyShipList();
}

}
