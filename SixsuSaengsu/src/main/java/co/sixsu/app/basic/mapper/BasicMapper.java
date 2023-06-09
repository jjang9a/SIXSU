package co.sixsu.app.basic.mapper;

import java.util.Date;
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

public interface BasicMapper {

	public String getRole(String id); // 권한정보 가져오기
	public EmpVO getEmp(String id); // 사원조회
	
	public List<CodeVO> getComList(String key); // 공통코드 분류 목록(그룹명으로 조회)
	
	public List<EmpVO> empList(); // 사원 전체목록 조회
	public int addEmp(EmpVO emp); // 사원 등록
	public int updatePw(EmpVO emp); // 사원 비밀번호 변경
	public int updateEmp(EmpVO emp); // 사원 정보 수정
	public List<EmpVO> searchEmp(SearchDTO dto); // 사원 검색

	public List<CodeVO> groupList(); // 그룹코드 조회
	public List<CodeVO> commList(SearchDTO dto); // 특정 공통코드 조회
	public int addCode(CodeVO code); // 공통코드 등록(추가)
	public int updateCode(CodeVO code); // 공통코드 수정
	public int addGroup(CodeVO code); // 그룹코드 등록
	public List<Map<String, String>> commGroupList(String code); //그룹별 상세코드 리스트
	
	public List<ProductVO> cpList(); // 완제품 목록 조회
	public int addCp(ProductVO prod); // 완제품 등록
	public int updateCp(ProductVO prod); // 완제품 수정
	public List<ProductVO> searchCp(SearchDTO dto); // 완제품 검색
	
	public List<ProductVO> spList(); // 반제품 목록 조회
	public int addSp(ProductVO prod); // 반제품 등록
	public int updateSp(ProductVO prod); // 반제품 수정
	public List<ProductVO> searchSp(SearchDTO dto); // 반제품 검색
	
	public List<MaterialVO> matList(); // 자재 목록 조회
	public int addMat(MaterialVO mat); // 자재 등록
	public int updateMat(MaterialVO mat); // 자재 수정
	public List<MaterialVO> searchMat(SearchDTO dto); // 반제품 검색
	
	public int checkBusNum(String num); // 사업자번호 중복 조회
	public List<BusVO> busList(); // 거래처 목록 조회
	public int addBus(BusVO bus); // 거래처 등록
	public int updateBus(BusVO bus); // 거래처 수정
	public List<BusVO> searchBus(BusVO bus); // 거래처 검색
		
	public List<ProcessVO> procList(); // 공정 목록 조회
	public int addProc(ProcessVO proc); // 공정 등록
	public int updateProc(ProcessVO proc); // 공정 수정
	public List<ProcessVO> searchProc(SearchDTO dto); // 공정 검색
	
	public List<BomVO> bomList(String id); // BOM내역 조회
	public List<ProductVO> activeCpList(); // 사용중인 완제품 조회
	public List<ProductVO> activeSpList(); // 사용중인 반제품 조회
	public List<ProductVO> activeMatList(); // 사용중인 자재 조회
	public List<ProcessVO> activeProcList(); // 사용중인 공정 조회
	public int addBom(BomVO bom); // BOM 등록
	public int updateBom(BomVO bom); // BOM 수정
	public int deleteBom(List<BomVO> list); // BOM 삭제	
	
	public List<FlowVO> flowList(String id);
	public int addFlow(FlowVO flow); // 공정흐름도 등록
	public int updateFlow(FlowVO flow); // 공정흐름도 수정
	public int deleteFlow(List<FlowVO> list); // 공정흐름도 삭제	
}
