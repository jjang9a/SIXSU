package co.sixsu.app.mapper;

import java.util.Date;
import java.util.List;

import co.sixsu.app.domain.common.EmpVO;

public interface CommonMapper {

	public Date getDate();
	
	public List<EmpVO> empList(); // 사원 전체목록 조회
	public int addEmp(EmpVO emp); // 사원 등록
	public int updatePw(EmpVO emp); // 사원 비밀번호 변경

}
