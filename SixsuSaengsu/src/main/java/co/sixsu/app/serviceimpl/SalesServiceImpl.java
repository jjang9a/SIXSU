package co.sixsu.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.mapper.SaleMapper;
import co.sixsu.app.service.SalesService;
@Service("salesService")
public class SalesServiceImpl implements SalesService{
@Autowired SaleMapper mapper;

@Override   // 모달창 전체 회원 조회
public List<EmpVO> getEmpList() {
	
	return mapper.empList();
}

@Override  //모달창 회원이름 조회
public List<EmpVO> getEmp1List(String keyword) {
	// TODO Auto-generated method stub
	return mapper.emp1List(keyword);
}

}
