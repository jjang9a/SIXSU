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

	@Override // 전체 사원목록 조회
	public List<EmpVO> getEmpList() {
		return mapper.empList();
	}

	@Override // 비밀번호 업데이트
	public boolean updatePw(EmpVO emp) {
		System.out.println("service : " + emp);
		return 	mapper.updatePw(emp) == 1;
	}

	@Override // 사원 등록
	public boolean addEmp(EmpVO emp) {
		return mapper.addEmp(emp) == 1;
	}
	
	
}
