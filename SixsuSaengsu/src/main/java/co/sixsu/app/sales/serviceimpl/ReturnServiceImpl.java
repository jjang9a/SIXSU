package co.sixsu.app.sales.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.sales.domain.RetVO;
import co.sixsu.app.sales.domain.ShipCompVO;
import co.sixsu.app.sales.domain.ShipVO;
import co.sixsu.app.sales.mapper.ReturnMapper;
import co.sixsu.app.sales.mapper.ShipMapper;
import co.sixsu.app.sales.service.ReturnService;

@Service("returnService")
public class ReturnServiceImpl implements ReturnService {
@Autowired ReturnMapper mapper;
@Autowired ShipMapper smapper;
@Override//
public List<ShipCompVO> orderComplete(String keyword) {
	// TODO Auto-generated method stub
	return mapper.orderComplete(keyword);
}

@Override
public boolean returnRequest(RetVO vo) {
	ShipVO ship = new ShipVO() ; //ship이라는 변수에 ship vo 를 담아준다
	ship.setOrdDetId(vo.getOrdDetId()); // 변수안에 반품 주문상세코드를 받아와서 넣어준다
	List<ShipVO> list = smapper.searchShip(ship); //기존의 출고테이블안에서 주문상세코드인걸 조회한다
	
	int qt = vo.getRetQt(); //반품요청수량
	int i= 0; // i = 0;
	while(qt >= list.get(i).getCpShipQt()) {
		RetVO ret = vo ;
		ret.setRetQt(list.get(i).getCpShipQt());
		ret.setCpShipId(list.get(i).getCpShipId());
		ret.setRetStat("RETREQ");
		ret.setEmpId(vo.getEmpId());
		ret.setRetNote(vo.getRetNote());
		mapper.insertReturn(ret);// 
		
		qt -= list.get(i).getCpShipQt();
		i++;
	}
	if(qt > 0 ) {
		RetVO ret=vo;
		ret.setRetQt(qt);
		ret.setCpShipId(list.get(i).getCpShipId());
		ret.setRetStat("RETREQ");
		ret.setEmpId(vo.getEmpId());
		ret.setRetNote(vo.getRetNote());
		mapper.insertReturn(ret);
	}
	
	
	
	return true;
}
@Override
public List<RetVO> searchReturn(RetVO vo) {
	// TODO Auto-generated method stub
	return mapper.searchReturn(vo);
}


}
