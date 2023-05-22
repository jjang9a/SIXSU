package co.sixsu.app.basic.service;

import java.util.List;

import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.MaterialVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.domain.SearchDTO;

public interface BasicService {

	List<EmpVO> getEmpList(); // 사원 전체목록 조회
	boolean updatePw(EmpVO emp); // 비밀번호 변경
	EmpVO addEmp(EmpVO emp); // 사원 등록
	boolean updateEmp(EmpVO emp); // 사원 정보 수정
	
	List<CodeVO> groupList(); // 그룹 코드 조회
	List<CodeVO> commList(SearchDTO dto); // 특정 공통 코드 조회
	boolean addCode(List<CodeVO> list); // 공통코드 등록(추가)
	boolean updateCode(List<CodeVO> list); // 공통코드 수정
	
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
	
	
}
