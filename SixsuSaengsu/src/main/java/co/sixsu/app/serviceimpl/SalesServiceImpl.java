package co.sixsu.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.common.BusVO;
import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.mapper.SaleMapper;
import co.sixsu.app.service.SalesService;
@Service("salesService")
public class SalesServiceImpl implements SalesService{
@Autowired SaleMapper mapper;

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

}
