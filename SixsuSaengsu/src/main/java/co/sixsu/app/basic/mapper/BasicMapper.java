package co.sixsu.app.basic.mapper;

import java.util.Date;
import java.util.List;

import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.MaterialVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.domain.SearchDTO;

public interface BasicMapper {

	public Date getDate();
	
	public List<EmpVO> empList(); // 사원 전체목록 조회
	public int addEmp(EmpVO emp); // 사원 등록
	public int updatePw(EmpVO emp); // 사원 비밀번호 변경
	public int updateEmp(EmpVO emp); // 사원 정보 수정

	public List<CodeVO> groupList(); // 그룹코드 조회
	public List<CodeVO> commList(SearchDTO dto); // 특정 공통코드 조회
	public int addCode(CodeVO code); // 공통코드 등록(추가)
	public int updateCode(CodeVO code); // 공통코드 수정
	
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
	
	
}
