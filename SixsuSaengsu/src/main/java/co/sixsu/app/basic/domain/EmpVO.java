package co.sixsu.app.basic.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO { // 사원 테이블 (employee)
	
	private String empId; // 사원번호
	private String empName; // 이름
	private String empTell; // 연락처
	private String empBirth; // 생년월일(yyyy/MM/dd)
	private String empHire; // 입사일(yyyy/MM/dd)
	private String empDept; // 부서명 (관리팀, 영업팀, 생산팀, 자재팀, 설비팀, 품질팀)
	private String empRk; // 직급 (관리자, 사원)
	private String empStat; // 재직상태 (재직, 휴직, 퇴사)
	private String empNote; // 비고
	private String empPw; // 비밀번호
	

}
