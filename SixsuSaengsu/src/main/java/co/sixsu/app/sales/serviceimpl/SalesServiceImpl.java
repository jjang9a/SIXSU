package co.sixsu.app.sales.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.mapper.SalesMapper;
import co.sixsu.app.sales.service.SalesService;
@Service("salesService")
public class SalesServiceImpl implements SalesService{
@Autowired SalesMapper mapper;

@Override   // 모달창 전체 사원 조회
public List<EmpVO> getEmpList() {
	
	return mapper.empList();
}

@Override  //모달창 회원사원 조회
public List<EmpVO> getEmp1List(String keyword) {
	// TODO Auto-generated method stub
	return mapper.emp1List(keyword);
}

@Override // 모달차 전체 거래처 조회
public List<BusVO> getBusList() {
	// TODO Auto-generated method stub
	return mapper.busList();
}

@Override //모달창 거래처이름 조회
public List<BusVO> getBus1List(String keyword) {
	// TODO Auto-generated method stub
	return mapper.bus1List(keyword);
}

@Override //자동으로 주문번호 등록
public String getMakeCode() {
	// TODO Auto-generated method stub
	return mapper.makeCode();
}

@Override
public List<OrdVO> getOrdList() {
	// TODO Auto-generated method stub
	return mapper.ordList();
}



}
