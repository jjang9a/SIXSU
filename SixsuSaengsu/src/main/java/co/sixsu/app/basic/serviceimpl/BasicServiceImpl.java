package co.sixsu.app.basic.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.SearchDTO;
import co.sixsu.app.basic.mapper.BasicMapper;
import co.sixsu.app.basic.service.BasicService;

@Service("BasicService")
public class BasicServiceImpl implements BasicService{
	
	@Autowired BasicMapper mapper;
	
	// 사원 관련
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
	public EmpVO addEmp(EmpVO emp) {
		emp.setEmpStat("재직");
		String bir = emp.getEmpBirth();
		String pw = bir.substring(2, 4) + bir.substring(5,7) + bir.substring(8);
		emp.setEmpPw(pw);
		mapper.addEmp(emp);
		return emp;
	}

	@Override // 사원정보 업데이트
	public boolean updateEmp(EmpVO emp) {
		return mapper.updateEmp(emp) == 1;
	}

	
	
	// 코드 관련
	@Override // 그룹코드 전체목록
	public List<CodeVO> groupList() {
		return mapper.groupList();
	}

	@Override // 선택된 공통코드 목록
	public List<CodeVO> commList(SearchDTO dto) {
		return mapper.commList(dto);
	}

	@Override
	public boolean addCode(List<CodeVO> list) {
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getComId() == null || list.get(i).getComId().equals("")){
				continue;
			}else {
				count += mapper.addCode(list.get(i));				
			}
		}
		return count >= 1;
	}

	@Override
	public boolean updateCode(List<CodeVO> list) {
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getComId() == null || list.get(i).getComId().equals("")){
				continue;
			}else {
				count += mapper.updateCode(list.get(i));				
			}
		}
		return count >= 1;
	}
	
	
}
