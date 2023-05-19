package co.sixsu.app.basic.mapper;

import java.util.Date;
import java.util.List;

import co.sixsu.app.basic.domain.EmpVO;

public interface BasicMapper {

	public Date getDate();
	
	public List<EmpVO> empList(); // 사원 전체목록 조회
	public int addEmp(EmpVO emp); // 사원 등록
	public int updatePw(EmpVO emp); // 사원 비밀번호 변경
	public int updateEmp(EmpVO emp); // 사원 정보 수정

}
