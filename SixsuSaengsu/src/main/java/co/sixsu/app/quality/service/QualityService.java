package co.sixsu.app.quality.service;

import java.util.List;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.QilVO;
import co.sixsu.app.quality.domain.QuaVO;

public interface QualityService {
	
		List<QuaVO> getArrList(); // 도착 자재 리스트
		List<QuaVO> arrRegList(); // 도착 자재 등록 리스트
		int insertArr(QuaVO am); // 도착 자재 등록
		

		List<QuaVO> proRecList(); // 자재 입고 검사 등록 리스트
		boolean insertPr(List<QuaVO> qlist); // 자재 입고 검사 등록
		boolean mrUpdate(List<MatreqVO> mlist); // 입고 검사 등록 시 자재 발주 상태 업데이트
		List<QuaVO> prInspList(); // 자재 입고 검사 리스트
		String psInspNum(); // 입고 검사 등록 시 검사 번호 자동 등록
		List<QuaVO> insertpro(List<QuaVO> list); //자재 입고 검사 등록 프로시저 사용
		List<QuaVO> inspItem(String matId); // 입고 검사 항목 불러오기
		List<QuaVO> insertPri(List<QuaVO> list); // 자재 입고 검사 결과 등록
		boolean priRegUpdate(QuaVO qua, MatreqVO mat); // 자재 입고 검사 결과 등록 시 업데이트
		
		
		//List<QuaVO> quaInspList(); // 검사 항목 리스트

		
		

}
