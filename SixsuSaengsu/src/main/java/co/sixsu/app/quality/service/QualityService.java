package co.sixsu.app.quality.service;

import java.util.List;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.PrdInspVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.domain.ReturnInspVO;
import co.sixsu.app.quality.domain.ShipInspVO;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;

public interface QualityService {
	
		// 장가애
		List<QuaVO> resultInspList(); // 2주이내 검사결과 리스트
		List<QuaVO> searchInsp(QuaVO vo); // 검색기능
		List<QuaVO> getWater(); // 원천수 리스트
		List<QuaVO> getDetail(String inspNum); // 검사결과 상세조회
		
		// 조민경
		// 검사 등록 공통
		List<QuaVO> inspItem(String matId); // 검사 항목 불러오기
		int insertQuaDet(List<QuaVO> list); // 세부 검사 insert
		
		// 자재 입고 검사 관련
		List<QuaVO> proRecList(); // 자재 입고 검사 등록 리스트
		boolean insertPr(List<QuaVO> qlist); // 자재 입고 검사 등록
		boolean mrUpdate(List<MatreqVO> mlist); // 입고 검사 등록 시 자재 발주 상태 업데이트
		List<QuaVO> prInspList(); // 자재 입고 검사 리스트
		int insertpro(List<QuaVO> list); //자재 입고 검사 등록 프로시저 사용
		boolean priRegUpdate(QuaVO qua); // 검사 결과 등록 시 검사공통 업데이트, 자재 발주 업데이트
		List<QuaVO> afterReqList();// 입고 검사 완료 리스트
		boolean delInsp(String inspNum);// 검사 완료 단건 삭제
		List<QuaVO> modInspItem(String inspNum);//수정시 검사 항목 불러오기
		List<QuaVO> updateQd(List<QuaVO> list);//수정 시 qua_details 업데이트
		int updateQc(List<QuaVO> list);//수정시 검사 공통 업데이트
		
		// 공정 검사 관련
		List<PrdInspVO> bpAddList(); // 공정 검사 등록 리스트 출력
		int bpdAdd(List<PrdInspVO> list);// 공정 검사 등록
		List<PrdInspVO> prwList(); // 공정 검사 대기 리스트
		List<PrdInspVO> prdComList(); // 공정 검사 완료 리스트
		int prdComUpdate(List<PrdInspVO> list); // 공정 검사 등록시 검사 공통 업데이트
		
		
		// 출고 검사 관련
		List<ShipInspVO> shInspList(); //  출고 검사 목록 리스트
		ShipInspVO shipInspAdd(ShipInspVO ship); // 출고 검사 등록
		boolean shipInspMod(ShipInspVO ship); // 출고 검사 수정
		
		
		// 반품 검사 관련
		List<ReturnInspVO> returnList(); // 반품 검사 목록 리스트
		ReturnInspVO returnInspAdd(ReturnInspVO ret);// 반품 검사 등록
		boolean returnInspMod (ReturnInspVO ret); // 반품 검사 수정
		
		// 사용 보류
		List<QuaVO> insertPri(List<QuaVO> list); // 자재 입고 검사 결과 등록
				

		
		

}
