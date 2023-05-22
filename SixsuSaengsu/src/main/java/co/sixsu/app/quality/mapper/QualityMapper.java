package co.sixsu.app.quality.mapper;

import java.util.List;

import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.QuaVO;

public interface QualityMapper {
	List<QuaVO> getArrList(); // 도착 자재 리스트
	List<QuaVO> arrRegList(); // 도착 자재 등록 리스트
	int insertArr(QuaVO am); // 도착 자재 등록
	
	List<QuaVO> proRecList(); // 자재 입고 검사 등록 리스트
	int insertPr(QuaVO am); // 자재 입고 검사 등록
	int mrUpdate(MatreqVO mat); // 입고 검사 등록 시 자재 발주 상태 업데이트
	List<QuaVO> prInspList(); // 자재 입고 검사 리스트
	String psInspNum(); // 입고 검사 등록 시 검사 번호 자동 등록
	void insertPro(QuaVO am); // 입고 검사 등록 프로시저 사용
	
	List<EmpVO> empList(); // 검사 담당자 조회 리스트
	List<EmpVO> sEmpList(String ename); // 검사 담당자 이름 조회

}
