package co.sixsu.app.basic.service;

import java.util.List;

import co.sixsu.app.basic.domain.EmpVO;

public interface BasicService {

	List<EmpVO> getEmpList(); // 사원 전체목록 조회
	boolean updatePw(EmpVO emp); // 비밀번호 변경
	boolean addEmp(EmpVO emp); // 사원 등록
	
}
