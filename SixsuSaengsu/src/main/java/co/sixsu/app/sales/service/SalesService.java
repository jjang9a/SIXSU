package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.sales.domain.OrdVO;

public interface SalesService {
	List<EmpVO> getEmpList(); // 모달창 전체 회원 조회
	
	List<EmpVO> getEmp1List(String keyword); //모달창 회원이름 조회
	
	List<BusVO> getBusList(); // 모달창 전체 거래처 조회
	
	List<BusVO> getBus1List(String keyword);//모달창 거래처이름 조회

	String getMakeCode();//자동으로 주문번호 등록
	
	List<OrdVO> getOrdList();
}
