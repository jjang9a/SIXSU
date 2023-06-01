package co.sixsu.app.basic.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class EmpVO implements UserDetails { // 사원 테이블 (employee)
	
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
	
	private String roleId;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(this.roleId));
		return auth;
	}

	@Override
	public String getUsername() {
		return empId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정이 만료되었니
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return empPw;
	}
}
