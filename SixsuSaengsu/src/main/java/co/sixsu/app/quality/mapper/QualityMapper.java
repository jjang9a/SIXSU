package co.sixsu.app.quality.mapper;

import java.util.List;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.PrdInspVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.domain.ReturnInspVO;
import co.sixsu.app.quality.domain.ShipInspVO;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;

public interface QualityMapper {
	
	// 장가애
	List<QuaVO> resultInspList(); // 2주이내 검사결과 리스트
	List<QuaVO> searchInsp(QuaVO search); // 검색기능
	List<QuaVO> getWater(); // 자재검사 원천수 리스트
	List<QuaVO> getDetail(String inspNum); // 검사결과 상세조회
	
	// 조민경
	// 검사 관련 공통 사용
	List<QuaVO> inspItem(String matId); // 검사 항목 불러오기
	int qComUpdate(QuaVO qua); // 검사 등록 시 qua_com 업데이트
	int insertQuaDet(QuaVO qua); // 검사 등록시 검사 세부 insert
	
	// 자재 입고 검사 관련
	List<QuaVO> proRecList(); // 자재 입고 검사 등록 리스트
	List<QuaVO> prInspList(); // 자재 입고 검사 리스트
	void insertPro(QuaVO am); // 입고 검사 등록 프로시저 사용
	int mUpdate(QuaVO qua); // 자재 입고 검사 등록 시 자재 발주 상태 업데이트
	List<QuaVO> afterReqList();//입고 검사 완료 리스트
	int delInsp(QuaVO qua);// 검사 완료 단건 삭제
	List<QuaVO> modInspItem(String inspNum);//수정시 검사 항목 불러오기
	int updateQd(QuaVO qua);//수정 시 qua_details 업데이트
	int updateQc(List<QuaVO> list);//수정시 검사 공통 업데이트
	
	// 공정 검사 관련
	List<PrdInspVO> bpAddList(); // 공정 검사전 리스트
	int bpdAdd(PrdInspVO prd);// 공정 검사 등록
	String pdInspNum(); // 공정 검사 등록 시 검사 번호 자동 등록
	List<PrdInspVO> prwList(); // 공정 검사 대기 리스트
	int prdComUpdate(PrdInspVO prd); // 공정 검사 결과 등록 검사 공통 업데이트
	List<PrdInspVO> prdComList(); // 공정 검사 완료 리스트
	int modPrdCom(QuaVO qua);// 공정 검사 수정 공통
	//int delPrdInsp(String inspNum); // 공정 검사 완료 단건 삭제
	
	
	// 출고 검사 관련
	List<ShipInspVO> shInspList(); //  출고 검사 목록 리스트
	String psInspNum(); // 출고 등록 시 검사 번호 자동 등록
	int insertShipCom(ShipInspVO com); // 출고 검사 등록 시 검사 공통 insert
	int insertShipDet(ShipInspVO det); // 출고 검사 등록 시 검사 상세 insert
	int updateShip(ShipInspVO prs); // 출고 검사 등록 시 완제품 출고 테이블 품질 검사 완료 업데이트
	int modShipCom(ShipInspVO vo); // 출고 검사 공통 수정
	int modShipDet(ShipInspVO vo); // 출고 검사 상세 수정

	
	//반품 검사 관련
	List<ReturnInspVO> returnList(); // 반품 검사 목록 리스트
	String qrInspNum();// 반품 검사 번호 자동 부여
	int isnertReturnCom(ReturnInspVO com); // 반품 검사 등록 시 검사 공통 insert
	int insertReturnDet(ReturnInspVO det); // 반품 검사 등록 시 검사 상세 insert
	int updateReturn(ReturnInspVO ret); // 반품 검사 등록 시 반품 테이블 업데이트
	int modReturnCom(ReturnInspVO com); // 반품 검사 공통 수정
	int modReturnDet(ReturnInspVO det); // 반품 검사 상세 수정
	
	
	// 사용 보류

	void reqInspProc(QuaVO qua);//자재 입고 검사 결과 등록 프로시저 사용
	int insertPr(QuaVO am); // 자재 입고 검사 등록
	int mrUpdate(MatreqVO mat); // 입고 검사 등록 시 자재 발주 상태 업데이트
}
