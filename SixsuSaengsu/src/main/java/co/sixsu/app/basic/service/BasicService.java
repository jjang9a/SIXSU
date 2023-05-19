package co.sixsu.app.basic.service;

import java.util.List;

import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.SearchDTO;

public interface BasicService {

	List<EmpVO> getEmpList(); // 사원 전체목록 조회
	boolean updatePw(EmpVO emp); // 비밀번호 변경
	boolean addEmp(EmpVO emp); // 사원 등록
	boolean updateEmp(EmpVO emp); // 사원 정보 수정
	
	List<CodeVO> groupList(); // 그룹 코드 조회
	List<CodeVO> commList(SearchDTO dto); // 특정 공통 코드 조회
	
}
