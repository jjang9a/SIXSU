package co.sixsu.app.service;

import java.util.List;

import co.sixsu.app.domain.common.EmpVO;

public interface SalesService {
	List<EmpVO> getEmpList(); // 모달창 전체 회원 조회
	
	List<EmpVO> getEmp1List(String keyword); //모달창 회원이름 조회
	
	
}
