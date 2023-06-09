package co.sixsu.app.basic.service;

import java.util.List;
import java.util.Map;

import co.sixsu.app.basic.domain.BomVO;
import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.FlowVO;
import co.sixsu.app.basic.domain.MaterialVO;
import co.sixsu.app.basic.domain.ProcessVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.domain.SearchDTO;
import co.sixsu.app.sales.domain.GridDataVO;

public interface BasicService {

	List<EmpVO> getEmpList(); // 사원 전체목록 조회
	boolean updatePw(EmpVO emp); // 비밀번호 변경
	EmpVO addEmp(EmpVO emp); // 사원 등록
	boolean updateEmp(List<EmpVO> emp); // 사원 정보 수정
	List<EmpVO> searchEmp(SearchDTO dto); // 사원 검색
	
	List<CodeVO> groupList(); // 그룹 코드 조회
	List<CodeVO> commList(SearchDTO dto); // 특정 공통 코드 조회
	boolean updateCode(GridDataVO<CodeVO> list); // 공통코드 추가, 수정
	boolean addGroup(CodeVO code); // 그룹코드 추가
	public List<Map<String, String>> commGroupList(String code); // 그룹코드별 조회
	List<CodeVO> getComList(String key); // 공정 구분 목록
	
	List<ProductVO> cpList(); // 완제품 목록 조회
	boolean addCp(ProductVO prod); // 완제품 등록
	boolean updateCp(ProductVO prod); // 완제품 수정
	List<ProductVO> searchCp(SearchDTO dto); // 완제품 검색
	
	List<ProductVO> spList(); // 반제품 목록 조회
	boolean addSp(ProductVO prod); // 반제품 등록
	boolean updateSp(ProductVO prod); // 반제품 수정
	List<ProductVO> searchSp(SearchDTO dto); // 반제품 검색
	
	List<MaterialVO> matList(); // 자재 목록 조회
	boolean addMat(MaterialVO mat); // 자재 등록
	boolean updateMat(MaterialVO mat); // 자재 수정
	List<MaterialVO> searchMat(SearchDTO dto); // 반제품 검색
	
	boolean checkBusNum(String num); // 거래처 중복확인
	List<BusVO> busList(); // 거래처 목록 조회
	boolean addBus(BusVO bus); // 거래처 등록
	boolean updateBus(BusVO bus); // 거래처 수정
	List<BusVO> searchBus(BusVO bus); // 거래처 검색
	
	List<ProcessVO> procList(); // 공정 목록 조회
	boolean addProc(ProcessVO mat); // 공정 등록
	boolean updateProc(ProcessVO mat); // 공정 수정
	List<ProcessVO> searchProc(SearchDTO dto); // 공정 검색
	
	List<BomVO> bomList(String id); // bom 내역 조회
	List<ProductVO> activeCpList(); // 활성화된 완제품 조회
	List<ProductVO> activeSpList(); // 활성화된 반제품 조회
	List<ProductVO> activeMaterialList(); // 활성화된 반제품 조회
	List<ProcessVO> activeProcList(); // 활성화된 공정 조회
	boolean addBom(List<BomVO> list); // BOM 등록
	boolean updateBom(GridDataVO<BomVO> list); // BOM 수정
	boolean deleteBom(List<BomVO> list); // BOM 삭제
	
	List<FlowVO> flowList(String id); // 제품별 공정흐름도
	boolean updateFlow(GridDataVO<FlowVO> list); // 공정흐름도 등록, 수정, 삭제
}
