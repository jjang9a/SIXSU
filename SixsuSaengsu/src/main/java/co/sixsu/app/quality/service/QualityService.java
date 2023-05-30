package co.sixsu.app.quality.service;

import java.util.List;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.PrdInspVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.domain.ShipInspVO;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;

public interface QualityService {
		
		// 검사 등록 공통
		List<QuaVO> inspItem(String matId); // 검사 항목 불러오기
		boolean priRegUpdate(QuaVO qua); // 검사 결과 등록 시 qua_com 업데이트
		List<QuaVO> insertPriAndUpdate(List<QuaVO> list); // 결과 등록 + 업데이트
		
		// 자재 입고 검사 관련
		List<QuaVO> proRecList(); // 자재 입고 검사 등록 리스트
		boolean insertPr(List<QuaVO> qlist); // 자재 입고 검사 등록
		boolean mrUpdate(List<MatreqVO> mlist); // 입고 검사 등록 시 자재 발주 상태 업데이트
		List<QuaVO> prInspList(); // 자재 입고 검사 리스트
		List<QuaVO> insertpro(List<QuaVO> list); //자재 입고 검사 등록 프로시저 사용
		List<QuaVO> afterReqList();// 입고 검사 완료 리스트
		boolean delReqInsp(String inspNum);// 검사 완료 단건 삭제
		List<QuaVO> modInspItem(String inspNum);//수정시 검사 항목 불러오기
		List<QuaVO> updateQd(List<QuaVO> list);//수정 시 qua_details 업데이트
		
		// 공정 검사 관련
		List<DetaWorkOrdrVO> bpAddList(); // 공정 검사 등록 리스트 출력
		List<PrdInspVO> bpdAdd(List<PrdInspVO> list);// 공정 검사 등록
		List<PrdInspVO> prwList(); // 공정 검사 대기 리스트
		List<PrdInspVO> prdComList(); // 공정 검사 완료 리스트
		
		// 출고 검사 관련
		List<ShipInspVO> shInspList(); //  출고 검사 목록 리스트
		
		
		// 사용 보류
		List<QuaVO> getArrList(); // 도착 자재 리스트
		List<QuaVO> arrRegList(); // 도착 자재 등록 리스트
		int insertArr(QuaVO am); // 도착 자재 등록
		//String psInspNum(); // 입고 검사 등록 시 검사 번호 자동 등록
		//List<QuaVO> reqInspProc(List<QuaVO> list);//자재 입고 검사 결과 등록 프로시저 사용
		List<QuaVO> insertPri(List<QuaVO> list); // 자재 입고 검사 결과 등록
				

		
		

}
