package co.sixsu.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.mapper.CommonMapper;
import co.sixsu.app.service.CommonService;

@Service("commonService")
public class CommonServiceImpl implements CommonService{
	
	@Autowired CommonMapper mapper;

	@Override
	public List<EmpVO> getEmpList() {
		return mapper.empList();
	}
	
	
}
