package co.sixsu.app.quality.mapper;

import java.util.List;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;

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
	List<QuaVO> inspItem(String matId); // 입고 검사 항목 불러오기
	int insertPri(QuaVO qua); // 자재 입고 검사 결과 등록
	int qComUpdate(QuaVO qua); // 자재 입고 검사 등록 시 qua_com 업데이트
	int mUpdate(QuaVO qua); // 자재 입고 검사 등록 시 자재 발주 상태 업데이트
	void reqInspProc(QuaVO qua);//자재 입고 검사 결과 등록 프로시저 사용
	
	List<DetaWorkOrdrVO> bpAddList(); // 공정 검사전 리스트
	

}
