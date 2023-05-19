package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;

public interface SalesService {
	List<EmpVO> getEmpList(); // 모달창 전체 회원 조회
	
	List<EmpVO> getEmp1List(String keyword); //모달창 회원이름 조회
	
	List<BusVO> getBusList(); // 모달창 전체 거래처 조회
	
	List<BusVO> getBus1List(String keyword);//모달창 거래처이름 조회
}
