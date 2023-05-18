package co.sixsu.app.service;

import java.util.List;

import co.sixsu.app.domain.common.EmpVO;

public interface CommonService {

	List<EmpVO> getEmpList(); // 사원 전체목록 조회
	boolean updatePw(EmpVO emp); // 비밀번호 변경
	boolean addEmp(EmpVO emp); // 사원 등록
	
}
