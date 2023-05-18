package co.sixsu.app.basic.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.mapper.BasicMapper;
import co.sixsu.app.basic.service.BasicService;

@Service("BasicService")
public class BasicServiceImpl implements BasicService{
	
	@Autowired BasicMapper mapper;

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
