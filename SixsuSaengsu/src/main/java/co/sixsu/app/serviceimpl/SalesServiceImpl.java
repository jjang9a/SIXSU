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

@Override
public List<EmpVO> getEmpList() {
	
	return mapper.empList();
}

}
